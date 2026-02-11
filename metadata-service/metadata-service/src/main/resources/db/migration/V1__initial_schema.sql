-- =========================================
-- USERS TABLE
-- =========================================
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    deleted_at TIMESTAMPTZ NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);


-- =========================================
-- FILES TABLE
-- =========================================
CREATE TABLE files (
    id BIGSERIAL PRIMARY KEY,
    file_name VARCHAR(255) NOT NULL,
    file_size BIGINT NOT NULL,
    block_size INT NOT NULL,
    total_blocks INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    user_id BIGINT NOT NULL,
    deleted_at TIMESTAMPTZ NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_files_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE RESTRICT,

    CONSTRAINT unique_user_file
        UNIQUE (user_id, file_name)
);


-- =========================================
-- BLOCKS TABLE
-- =========================================
CREATE TABLE blocks (
    id BIGSERIAL PRIMARY KEY,
    file_id BIGINT NOT NULL,
    block_index INT NOT NULL,
    size INT NOT NULL,
    checksum VARCHAR(64) NOT NULL,
    status VARCHAR(20) NOT NULL,
    deleted_at TIMESTAMPTZ NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_blocks_file
        FOREIGN KEY (file_id)
        REFERENCES files(id)
        ON DELETE RESTRICT,

    CONSTRAINT unique_file_block
        UNIQUE (file_id, block_index)
);


-- =========================================
-- DATANODES TABLE
-- =========================================
CREATE TABLE datanodes (
    id BIGSERIAL PRIMARY KEY,
    host VARCHAR(255) NOT NULL,
    port INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    last_heartbeat_at TIMESTAMPTZ NULL,
    capacity_bytes BIGINT NOT NULL,
    used_bytes BIGINT NOT NULL,
    deleted_at TIMESTAMPTZ NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT unique_host_port
        UNIQUE (host, port)
);


-- =========================================
-- BLOCK REPLICAS TABLE
-- =========================================
CREATE TABLE block_replicas (
    id BIGSERIAL PRIMARY KEY,
    block_id BIGINT NOT NULL,
    datanode_id BIGINT NOT NULL,
    status VARCHAR(20) NOT NULL,
    deleted_at TIMESTAMPTZ NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_replica_block
        FOREIGN KEY (block_id)
        REFERENCES blocks(id)
        ON DELETE RESTRICT,

    CONSTRAINT fk_replica_datanode
        FOREIGN KEY (datanode_id)
        REFERENCES datanodes(id)
        ON DELETE RESTRICT,

    CONSTRAINT unique_block_datanode
        UNIQUE (block_id, datanode_id)
);
