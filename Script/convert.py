import json
import os
import html


root = os.path.join("..", "Source")
output_filename = "Output.html"

print("Starting conversion...")


def create_page(title_txt, aim_txt, algo_txt, code_txt, out_txt, ex_num, date="--/--/--"):
    return f"""
            <p style="font-size: 20px">
                <label style="font-size: inherit;">Experiment - {ex_num}</label>
                <label style="font-size: inherit; float: right">Date: {date}</label>
            </p>
            <h1 class="underline" style="text-transform: uppercase;" align="center">
                {title_txt}
            </h1>
            <h3 class="underline">Aim:</h3>
            {aim_txt}
            <h3 class="underline">Algorithm:</h3>
            <pre>{algo_txt}</pre>
            <h3 class="underline">Program Development:</h3>
            <pre>{html.escape(code_txt)}</pre>
            <h3 class="underline">Output:</h3>
            <pre class="output-txt">{out_txt}</pre>
            <br/><div class="page-break"></div>"""


main_str = ""
with open("Data.json", "r") as f:
    os.chdir(root)
    data = json.loads(f.read())

    for item in data:
        cycle = item['cycle']
        questions = item['questions']
        cycle_path = os.path.join(root, f"section{chr(64 + cycle)}")

        ex = 1
        for question in questions:
            title = question['title']
            qs = question['question']
            date = question['date']

            # Name of the file is Pgm<program number><Program section>.java
            code_path = os.path.join(cycle_path, f"Pgm{ex}{chr(64 + cycle)}.java")
            algo_path = os.path.join(cycle_path, f"Pgm{ex}_algo.txt")
            out_path = os.path.join(cycle_path, f"Pgm{ex}_out.txt")

            code = open(code_path, "r").read()
            algo = open(algo_path, "r").read()
            out = open(out_path, "r").read()
            main_str += create_page(title, qs, algo, code, out, ex, date)

            ex = ex + 1

final_out = """
        <html>
            <head>
                <style>
                    * , body {
                        font-size: 20px;
                    }
                    @media print {
                        .page-break {
                            page-break-before: always;
                        }
                    }
                    .underline {
                        text-decoration: underline;
                    }
                    .output-txt {
                        font-family: monospace;
                        background-color: black;
                        color: white;
                        width: min-content;
                        padding: 20px 10px;
                        padding-right: 40px;
                        border-radius: 8px;
                        font-size: 0.8rem;
                    }
                    pre {
                        overflow-x: auto;
                        white-space: pre-wrap;
                        white-space: -moz-pre-wrap;
                        white-space: -pre-wrap;
                        white-space: -o-pre-wrap;
                        word-wrap: break-word;
                    }
                </style>
            </head>
            <body>
    """ + main_str + """
            </body>
        </html>
    """

os.chdir("..")

with open(output_filename, "w") as output:
    output.write(final_out)

print("Finished conversion")
print("Saved to file:", output_filename)
