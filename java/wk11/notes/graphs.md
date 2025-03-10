### Introduction to Graphs

> A **_Graph_** is a data structure for representing connections among items, and consists of vertices(node, vertex) connected by edges(connection, "_line_ between each node").
>
> **_Vertex_**: A Node representing an item in a graph.
>
> **_Edge_**: A connection between two vertices in a graph.
>
> ### NOTE: An edge can only have exactly two vertices connected to it. Vertices can have any number of edges connected to them.

---

### Adjacency and Paths

> in a graph:
>
> - Two vertices are **_adjacent_** if they are connected by an edge.
> - A **_Path_** is a sequence of edges leading from a source(starting) vertex to a destination(ending) vertex. The **_Path length_** is the number of edges in the path.
> - The **_distance_** between two vertices is the number of edges on the shortest path between those vertices.

# 11.2 Applications of Graphs

### Geographic maps and Navigation

> Graphs are often used to represent a geographic map, which can contain information about places and travel routes. Ex: Vertices in a graph can represent airports, with edges representing available flights. Edge weights in such graphs often represent the length of a travel route, either in total distance or expected time taken to navigate the route. Ex: A map service with access to real-time traffic information can assign travel times to road segments.

# 11.3 Graph representations: Adjacency lists

### Adjacency Lists

> Various approaches exist for representing a graph data structure. A common approach is an adjacency list. Recall that two vertices are **_adjacent_** if connected by an edge. In an **_adjacency list_** graph representation, each vertex has a list of adjacent vertices, each list item representing an edge.
