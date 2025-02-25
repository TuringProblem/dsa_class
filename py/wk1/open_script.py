import csv
import json
import os
import re


def csv_to_json(csv_filepath, json_filepath) -> None:
    data = []
    with open(csv_filepath, mode="r", encoding="utf-8") as csv_file:
        csv_reader = csv.DictReader(csv_file)
        for row in csv_reader:
            data.append(row)

    with open(json_filepath, mode="w", encoding="utf-8") as json_file:
        json.dump(data, json_file, indent=4)


def extract_fields(messy_file, cleaned_file) -> None:
    with open(messy_file, "r", encoding="utf-8") as f:
        fragments_list = json.load(f)
    result = {}
    pair_pattern = r'\\"([^\\"]+)\\"\s*:\s*\\"([^\\"]+)\\"'

    for item in fragments_list:
        line = item.get("[", "")
        matches = re.findall(pair_pattern, line)
        for key, value in matches:
            result[key.strip()] = value.strip()

    with open(cleaned_file, "w", encoding="utf-8") as f:
        json.dump(result, f, indent=4)

    print(f"Extracted cleaned JSON written to {cleaned_file}\n")
    print(f"Would you like to open {cleaned_file} now? [y] or [n]\n")
    result = input("Answer: ")
    if result == "y":
        if os.path.exists("report.json"):
            os.system("nvim report.json")
        else:
            os.system("nvim names.json")


csv_file_path: str = str(input("Please enter the file path for the csv file: "))
json_file_path: str = "out.json"
csv_to_json(csv_file_path, json_file_path)
new_file_path = str(input("Please enter the file path for the json file: "))

extract_fields(json_file_path, new_file_path)
