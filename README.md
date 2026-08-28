# Computer Science at UNRC, Argentina, 2026.

## Overview
This repository contains the materials and notes from the second year of the Computer Science degree at the Universidad Nacional de Río Cuarto, Argentina. It covers the courses taken during the year, with theory slides (PDF/ DOCX), practice sheets, the author's solutions (lab/code), and work in progress. All the material a student uses in their courses is gathered here in one place.

## Structure
The repository is organized into one folder per course. Each folder contains the theory, practical work, and the solutions/work-in-progress relevant to that course.

```
/
├── algoritmos-y-estructuras-de-datos-2/
│   ├── algorithms/                 # Algorithm implementations (Haskell, JS) by topic
│   │   ├── efficiency/             #   Notes on complexity of basic algorithms
│   │   └── sorting/                #   Sorting algorithms + visualizations
│   ├── practico/                   # Practice sheets (PDF) + solutions (per practice)
│   │   └── tads/                   #   Gradle project: source code of the TADs
│   ├── teorico/                    # Theory slides (PDF): OOP, TADs, sorting,
│   │                               #   trees, graphs, runtime, etc.
│   └── tp2026-luna-ollo-saavedra/  # Group final project (degreesOfSeparation,
│                                   #   wordCounter)
├── analisis-y-diseño-de-algoritmos/
│   ├── practico/                   # Practice sheets + solutions (01-lau-luna, practica-2)
│   ├── teorico/                    # Course notes (PDF)
│   ├── recursion.hs                # Recursion exercises in Haskell
│   └── recursion.py                # Recursion exercises in Python
├── bases-de-datos/
│   ├── practico/                   # Practices 1 and 2 (PDF + drawio solutions)
│   └── teorico/                    # Theory (introduction, entity-relationship)
├── computacion-y-sociedad/         # Theory slides (PDF): history, ethics,
│                                   #   workplace safety, licenses, contracts
├── ingenieria-de-software/
│   ├── practico/                   # Practice sheets + solutions (UML/drawio)
│   ├── taller/                     # Workshop projects (e.g. tarea-server-http)
│   └── teorico/                    # Theory slides (PDF): intro to SE, UML
├── ingles-1/
│   ├── actividades/                # Activities (DOCX)
│   └── practicas/                  # Practice guides (PDF/DOCX)
├── ingles-2/
│   └── (guides and books as PDF, e.g. intro to scientific
│       programming with Python)
├── organizacion-de-computadoras/
│   ├── algorithms/                 # Algorithm simulations (multiplication, division)
│   ├── assembly-random/            # Random assembly exercises (.asm)
│   ├── cpusim/                     # CPU Sim project files (P1, P1-v2, P1-V3)
│   ├── falstad/                    # Circuit simulations (txt/png)
│   ├── material/                   # Supporting material and slides
│   ├── midterm-models/             # Exam models and past midterms
│   ├── nasm/                       # NASM assembly
│   ├── practico/                   # Practice guides + solutions
│   ├── sasm/                       # SASM (SASM IDE) practices
│   ├── tp/                         # Practical work (e.g. sumaMatrices.asm)
│   └── tp-organizacion-de-computadoras/
├── LICENSE
└── README.md
```

## Course Descriptions
- **Algorithms & Data Structures II**: Covers the specification and implementation of abstract data types (ADTs), object-oriented programming, collections (sequences, sets, maps), inheritance and polymorphism, error handling, testing and debugging, runtime analysis, sorting algorithms, and data structures such as trees and graphs. Code is written in Haskell, JavaScript, and Java (Gradle).
- **Algorithm Analysis & Design**: Analysis and design of algorithms, with exercises solved mainly in Haskell and Python. Covers recursion, complexity, and algorithm design techniques.
- **Databases**: Introduction to databases and the Entity-Relationship model, with ER diagrams designed in drawio.
- **Computing & Society**: History and social context of computing, social implications, professional ethics and responsibility, risks and occupational safety, and software licenses and contracts.
- **Software Engineering**: Introduction to software engineering and its organization, and UML graphical notations. Includes practical work with UML diagrams and a workshop on building an HTTP server.
- **English I**: Practice guides and activities for the first level of the English for Computer Science course.
- **English II**: Second level of the English course, including scientific programming with Python.
- **Computer Organization**: Covers digital circuits (simulated in Falstad), CPU simulation (CPUsim), assembly programming (NASM, SASM, and other tools), machine-level code, and midterm preparation material.

## How to Use the Repo
1. Clone the repository to your local machine using:
   ```
   git clone https://github.com/lau-luna/uni-2026.git
   ```
2. Navigate to the specific course folder to access the notes for that subject.
3. Feel free to contribute by editing or adding your own notes:
   1. Fork the repository.
   2. Make your changes.
   3. Create a pull request to merge your changes back into the main repository.
4. Some course subfolders (e.g. the practical work) are their own git repositories; check for a `.git` folder inside them.
5. Some solutions and code files are work in progress.