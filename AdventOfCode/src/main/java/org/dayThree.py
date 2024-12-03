import re

class SolutionBase:
    # Basis-Klasse (falls nötig, erweitere sie)
    pass

class Solution(SolutionBase):
    def part1(self, data):
        # Regex für mul(X,Y)
        pattern = r"mul\((\d{1,3}),(\d{1,3})\)"
        matches = re.findall(pattern, "".join(data))

        # Summiere alle Ergebnisse
        result = sum(int(x) * int(y) for x, y in matches)

        return result

    def part2(self, data):
        # Regex für mul(X,Y), do(), und don't()
        pattern = r"(mul\((\d{1,3}),(\d{1,3})\)|do\(\)|don't\(\))"
        instructions = re.findall(pattern, "".join(data))

        enabled = True  # Multiplikation standardmäßig aktiviert
        result = 0

        for inst in instructions:
            match inst[0]:
                case "do()":
                    enabled = True  # Aktiviert Multiplikationen
                case "don't()":
                    enabled = False  # Deaktiviert Multiplikationen
                case _ if enabled:  # Nur ausführen, wenn aktiv
                    result += int(inst[1]) * int(inst[2])

        return result


# Datei einlesen und Lösung berechnen
if __name__ == "__main__":
    file_path = "src/main/java/org/example/Dateien/Day 3"  # Pfad zur Datei

    try:
        # Datei öffnen und Daten einlesen
        with open(file_path, "r") as file:
            data = file.readlines()

        # Lösung initialisieren
        solution = Solution()

        # Ergebnisse berechnen
        part1_result = solution.part1(data)
        part2_result = solution.part2(data)

        # Ergebnisse ausgeben
        print(f"Part 1 result: {part1_result}")
        print(f"Part 2 result: {part2_result}")

    except FileNotFoundError:
        print(f"Die Datei '{file_path}' wurde nicht gefunden.")
    except Exception as e:
        print(f"Ein Fehler ist aufgetreten: {e}")