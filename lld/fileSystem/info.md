# Design an In-Memory POSIX File System

## 1.Requirements

### Functional

Hierarchical directories (/a/b/c) </br>
Files with content </br>
Metadata (permissions, owner, size, timestamps) </br>
POSIX-like operations: </br>
mkdir, rmdir </br>
create, read, write, delete  </br>
ls, stat  </br>
move, rename  </br>
Absolute paths  </br>
Atomic operations  </br>

### Non-Functional  </br>

Thread-safe </br>
Efficient path lookup </br>
In-memory only (no persistence) </br>
Atomicity guarantees (no partial updates) </br>
Scalable to many files/directories </br>


## 2. High-Level Architecture

```
FileSystem
 ├── Root Directory (/)
 ├── Path Resolver
 ├── Lock Manager
 └── Inode Manager
```

 Key idea:

Everything is represented as nodes (inodes). </br>
Directories map names → child nodes. </br>
Files store byte content. </br>

## 3. Core Data Model


