# Letterbox implementation

Here's my letterbox implementation. It started out reasonably small, and then I took
it as a challenge to make it as small and dependency-less as possible. So you're
left with a main solver for a single puzzle with precisely zero import statements
and 25 lines of text.

## Execution

To execute all puzzles in `puzzles.txt`:

```mvn clean package exec:java```
