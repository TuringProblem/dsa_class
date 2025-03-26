name: str = "john"
print(f"hello {name}")

# Adjacency List Representation
graph = {"A": ["B", "C"], "B": ["A", "D"], "C": ["A", "E"], "D": ["B"], "E": ["C"]}

# Add an edge
graph["A"].append("D")

# Print the graph
print(graph)
