# Strongly Connected Components
Algorithm to detect the strongly connected components of a directed graph.

## Definition
Strongly connected components in a graph `G = (V, E)` are every pair of vertices u and v in a set of vertices C in V that has a path inside C from u to v and from v to u.

In other words, it separates each depth-first tree of a depth-first forest resulting from a DFS procedure into components.

## Usage
First line: N that is the number of vertices. M that is the number of edges.

Next M lines: src that is the number of the source vertex and dst that is the number of destination vertex.

## Example
```shell
8 14
1 2
2 3
2 6
2 5
3 4
3 7
4 3
4 8
5 1
5 6
6 7
7 6
7 8
8 8
```

#### Return
```shell
Component 1: 2 5 1
Component 2: 4 3
Component 3: 6 7
Component 4: 8
```
