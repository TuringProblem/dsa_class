let result =
    [1; 2; 3; 4]
  |> List.map(fun x -> x * 2)
  |> List.filter(fun x -> x > 4)
  |> List.fold_left(+) 0

let () =
  Printf.printf "Result: %d\n" result;



