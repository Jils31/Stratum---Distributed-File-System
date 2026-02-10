**Explain Stratum to a junior engineer in 2–3 sentences.**

Stratum is a distributed file storage system where large files are split into blocks and stored across
multiple DataNodes. A central Metadata service manages file metadata, blocks placement, blocks replication 
whereas the DataNodes stores the actual data and perform the operations which are needed.

**Why did we separate the Metadata service and the Datanode service?**

We separate this both the service to clearly differentiate the decision-making from execution.\
The Metadata service acts as the control plane, managing file metadata, block placement, block replication and node health.\
The DataNode service acts as the data plane, storing actual data, replication and where the reads/writes happen.

This separation improves scalability, fault tolerance and making debugging easier.

#### Metadata decides what should happen; DataNodes execute how it happens.

**What problem do heartbeats solve in Stratum, and why are normal health checks not enough?**

Normal health checkpoints only tells us if the service is up and responding, which is enough for the stateless microservices.\
In Stratum, DataNodes stores actual blocks, so node liveness directly affects the placement decision and data safety. Heartbeats provides
continuous signals whether a datanode is alive and reliable over time, allowing the Metadata service to make correct decisions about placement, replication and other things.

**Why do we need a separate `block_replicas` table instead of storing datanode_id directly in the `blocks` table?**

A block is a logical chunk of a file, while replicas represent the physical copies of that block on different DataNodes.Since one block can be replicated along different DataNodes thus storing it into blocks
table is insufficient.The block-replicas table allows us to have one-many relationships.
