let rec sort lst =
    match lst with
      [] -> []
    | head :: tail -> insert head (sort tail)
  and insert elt lst =
    match lst with
      [] -> [elt]
    | head :: tail -> if elt <= head then elt :: lst else head :: insert elt tail;

let list = [5; 10; 1; 59; 70; 60; 69; 2; 1];
Printf.printf(list)

