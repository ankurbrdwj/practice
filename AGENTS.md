# AGENTS.md

This file provides guidance to Codex (Codex.ai/code) when working with code in this repository.

## Build & Test Commands

```bash
# Build
./gradlew build

# Run all tests
./gradlew test

# Run a single test class
./gradlew test --tests "com.ankur.interview.practice.arrays.TestCalendarMatching"

# Run a single test method
./gradlew test --tests "com.ankur.interview.practice.arrays.TestCalendarMatching.TestCase1"

# Continuous test run on change
./gradlew test --continuous
```

## Architecture

This is a Spring Boot project used purely as a build harness — the application itself (`PracticeApplication`) is empty. All meaningful code lives under `src/main/java/com/ankur/interview/` and its mirror test tree under `src/test/`.

### Package layout

```
com.ankur.interview
├── hackerrank/        # HackerRank-specific problems (standalone classes)
└── practice/
    ├── arrays/        # Array & interval problems
    ├── strings/       # String manipulation & search
    ├── trees/
    │   ├── binarytrees/        # General binary tree problems
    │   └── binarysearchtrees/  # BST-specific problems
    ├── graphs/        # BFS, DFS, Dijkstra, island problems
    ├── dyanamicprogramming/    # DP problems (note the typo in package name)
    ├── greedy/        # Greedy algorithm problems
    ├── heaps/         # Heap / priority queue problems
    ├── stacks/        # Stack problems
    ├── lists/         # Linked list problems
    ├── recursion/     # Pure recursion problems
    └── popular/       # Commonly asked interview problems
```

### Conventions

- Each problem is typically a single class with a `public static` method. Tests call that method directly — no dependency injection or Spring context is used in tests.
- Inner static classes (e.g. `CalendarMatching.StringMeeting`) are used to co-locate supporting data types with the algorithm.
- Test classes are named `Test<ClassName>` and use JUnit 5 (`@Test`, `Assertions.*`).
- The `dyanamicprogramming` package name is intentionally misspelled — match it exactly when creating new files there.

### Dependencies of note

- `princeton-java-algorithms` — sedgewick's standard library (available for graph/sort utilities)
- `junit-jupiter:5.8.1` — declared in `implementation` scope (not just test), so it's available in main sources too