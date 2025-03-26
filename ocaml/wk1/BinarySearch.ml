(* @author: { @Override } | @date 20250320 : 1202*)

let bSearch(arr, target: int): int =
  let low: int = 0;
  let high: int = Array.length arr - 1;
  while low <= high do
    let mid: int = (low + high) / 2;
    if arr.[mid] = target then
      mid  (* Target found, return index *)
    else if arr.[mid] < target then
      low <- mid + 1  (* Search in the right half *)
    else
      high <- mid - 1  (* Search in the left half *)


let () =
  let arr = [|1; 2; 3; 4; 5; 6; 7; 8; 9; 10|] in
  let target = 7 in
  let result = bSearch(arr, target) in
  if result >= 0 then
    Printf.printf "Element %d found at index %d\n" target result
  else
    Printf.printf "Element %d not found in the array\n" target



