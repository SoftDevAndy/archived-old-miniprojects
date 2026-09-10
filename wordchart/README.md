# Word Chart

A Python script that downloads a webpage, removes common words, counts the remaining words, and displays the most frequent results as a bar chart.

## Run on Windows

Install Python 3 and ensure `python` and `pip` are available on your PATH.

Open PowerShell in this project's `wordchart` folder and install the pinned dependencies:

```powershell
python -m pip install -r requirements.txt
```

Run the script with a URL and the number of words to display:

```powershell
python wordchart.py "https://www.yahoo.com/news/" 10
```

The script opens a chart window after downloading the page. The target site must be reachable and allow the request.

## Usage

```text
python wordchart.py [-h] url max
```

- `url` — Webpage URL to analyse.
- `max` — Number of words to display in the chart.

The common-word list is read from `10k.txt`, so run the script from the project folder.

## Project Files

- `wordchart.py` — Scraping, word counting, and chart generation.
- `10k.txt` — Words excluded from the results as common words.
- `requirements.txt` — Python dependencies.
