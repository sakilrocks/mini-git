# mini-git

*mini-git* is a lightweight command line version control tool written in Java that mimics the core functionality of Git.  
It lets you initialize a repository, track files and commit changes. 

---

## Features

- Initialize a new repository (`minigit init`)
- Stage files for tracking (`minigit add <file>`)
- Commit changes with a message (`minigit commit -m "message"`)
- Maintains a history of commits and file snapshots
- Stores metadata in JSON for easy readability

---

## Folder Structure

```
minigit/
├── src/
│   ├── Main.java
│   ├── commands/
│   │   ├── InitCommand.java
│   │   ├── AddCommand.java
│   │   └── CommitCommand.java
│   └── core/
│       ├── Repository.java
│       ├── Index.java
│       ├── Commit.java
│       └── Utils.java
└── .minigit/ (auto-created after init)
     └── commits/
          ├── meta.json    # commit info (id, timestamp, message)
          └── index.json   # tracked files and hashes
```

---

## How it Works

- init -> creates a hidden .minigit/ folder containing commit data
- add -> records file hash (SHA-256) and adds it to the index
- commit -> creates a snapshot of tracked files and saves metadata
- HEAD -> always points to the latest commit ID

---

## Setup

### Prerequisites

- Java 17 or higher  
- Maven or manual dependency management  

If using Maven:
```
mvn clean compile
```

If using Javac manually:
```
javac -cp .:json.jar src/**/*.java
```

---

## Usage

### Initiaize a new repo:
```
java -cp .:json.jar src.Main init
```

### Add files to tracking:
```
java -cp .:json.jar src.Main add file.txt
```

### Commit changes:
```
java -cp .:json.jar src.Main commit -m "Initial commit"
```
