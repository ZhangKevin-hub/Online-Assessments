def match_codes_with_panel(codes, panel):
    matches = []

    for code in codes:
        isMatch = False

        for start in range(1, len(code)):
            pattern = code[start:]
            pattern_length = len(pattern)

            if len(panel) >= start + pattern_length:
                panel_substring = panel[start:start + pattern_length]

                if pattern == panel_substring:
                    matches.append(pattern)
                    isMatch = True
                    break

        if not found_match:
            matches.append("no found")

    return matches

# Example usage
if __name__ == "__main__":
    # Codes and Panel Defined here
    codes = ["123", "456", "789", "12"]
    panel = "123456789"

    # Run the function
    result = match_codes_with_panel(codes, panel)

    # Print the results
    print("Codes:", codes)
    print("Panel:", panel)
    print("Matches:", result)