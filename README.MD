Stratum is a layered event driven distributed file system that supports 
fault-tolerant file uploads and downloads using block-based storage,
metadata orchestration, caching and asynchronous replication.

What is a file in stratum?\
It is a logical entity representing the user uploaded file.\
File itself is the metadata that is owned by Metadata service , and it includes: file name, file size, file type etc.\
Also one more important thing is that the files are not stored in the database, their metadata is stored as the DBs are bad at large binary blobs.


What is a block/chunk?\
A physical unit of storage, which represents the fix-size of the chunk in a file.\
It is stored on the datanode and can have multiple replicas across DataNode.

What is DataNode?\
It is a storage server in the distributed file system, which stores the actual blocks/chunks on its local disk.\
A microservice instance running on some port and stored it locally before moving to the cloud storage.

Control Plane vs Data Plane

Control plane = The brain (This is where the decisions are made)\
In stratum - Metadata service is my control plane.\
This just decides where the file should be stored, or where does the replicas go, how many blocks does it have, etc.

Data plane = The muscles (This is where the actual things happen, like storage, replicating,deleting etc.)\
In stratum - Datanode service is my data plane.\
This is where the actual storage of blocks, replication of them, deleting them and things around that happens.

We separated the control plane from the data plane.

Can a block exist without a file?\
A block cannot exist independently without the file.When a file is deleted the blocks are logically removed from the metadata.
Physical replicas may continue to exist in the DataNode temporarily and can be cleaned up asynchronously.
