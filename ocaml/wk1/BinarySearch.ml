(* @author: { @Override } | @date 20250320 : 1202*)

let bSearch(arr: int array, target: int): int =
  let low: int = 0;
  let high: int = Array.length arr - 1;

  while low <= high do 
    middle: int = low + (high - low) / 2;
    if arr[|middle|] = target then 
      middle
    else if array[|middle|] < target then
      low := middle + 1;
    else 
      high := middle - 1;
  done;
  -1;



let main() = 
  let array: int array = [|1; 2; 3; 4; 5; 6; 7 |];
  let target: int = 4;
  let result: int = bSearch(array, target);
  if result != -1 then
    Printf.printf "Element found at index: %d\n" result
  else
    Printf.printf "Element not found in the array\n"





