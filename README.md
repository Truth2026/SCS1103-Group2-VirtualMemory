# What Stays in RAM? Page Replacement for a Low-Memory Server

**SCS 1103 Operating System Concepts, Assignment 1 | Group 2**

https://github.com/n02646251d-png/SCS1103-Group2-VirtualMemory

## Group members and roles

| # | Name | Reg no. | Role |
| --- | --- | --- | --- |
| 1 | Precious Memory Charamba | N02647137Y | Research |
| 2 | Sibusisiwe Ndawana | N02649564C | Research |
| 3 | Rutendo Murambiwa | N02646586H | Research |
| 4 | Elina Maraidza | N02646369M | Research |
| 5| Tawana Macheka | N02643436W | Presenting |
| 6| Carol Kachale | N02645210Y | Presenting |
| 7| Shoko Ezra | N02646251D | Build |
| 8| Kuzakwawo Lesean | N02653121A | Build |
| 9| Promise James | N02645998X | Build |
|10| Taonashe Manyonga | N02646383W | Build |
|11| Kuzhumbwa Tatenda | N02653651W | Writing |
|12| Allan Mashuwa | N02641360C | Writing |
|13| Miracle Mazulu|N02644912y |Writing |
##Research question

On a low-memory server replaying the Azure Functions 2021 trace, which page replacement policy (FIFO, LRU or Clock) causes the fewest page faults at the same RAM size?

## Aim

To compare FIFO(First In ,First Out), LRU (Least Recently Used) and Clock page replacement on a real serverless workload, and find out which one keeps the most useful functions in a limited amount of RAM.

## Objectives

1. Build a Python simulator that replays a list of function calls through FIFO, LRU and Clock with a fixed number of RAM slots.
2. Run all three policies on the Azure Functions 2021 trace, treating each function as a page and each invocation as a page request, at RAM sizes of 1%, 5%, 10% and 25% of the distinct functions in the data.
3. Evaluate by measuring the page-fault rate (faults ÷ invocations) and the hit rate (hits ÷ invocations) at each RAM size, with FIFO as the baseline. A policy succeeds if it cuts the fault rate by at least 10% (relative to FIFO) at 3 or more of the 4 RAM sizes. The best policy is the one that succeeds and has the lowest average fault rate.

## OS concept

Virtual memory and page replacement. When RAM is full, the OS must choose which page to remove to make room for a new one. A bad choice causes another page fault, and a page fault means a slow trip to the disk.

## Why it matters

Cloud servers cannot keep every function in RAM(Random Acess Memory), so they must decide what to remove. Shahrad et al. (USENIX ATC 2020, "Serverless in the Wild: Characterizing and Optimizing the Serverless Workload at a Large Cloud Provider", Microsoft Azure) report that AWS and Azure keep idle functions in memory for a fixed 10 and 20 minutes, and that a fixed 2-hour window wastes almost 30% more memory than a 10-minute one. A small or student server has far less RAM, so a bad eviction choice hurts even more.

## Data

- **Dataset:** Azure Functions Invocation Trace 2021 (`AzureFunctionsInvocationTraceForTwoWeeksJan2021.rar`), Microsoft
- **Link:** https://github.com/Azure/AzurePublicDataset/blob/master/AzureFunctionsInvocationTrace2021.md
- **Year:** two weeks from 31 January 2021
- **Licence:** CC-BY Attribution License, as written on the source page
- **Citation:** Zhang et al., "Faster and Cheaper Serverless Computing on Harvested Resources", SOSP 2021
- **Columns used (all 4):** `app`, `func`, `end_timestamp`, `duration`
- **Why these columns:** together they give a real, ordered list of which functions were called and when. That is the stream of page requests a page-replacement policy needs.
- **Privacy:** the app and function IDs are encrypted, so there is no personal data.

### Stand-in (proxy) and limits

The trace has no memory sizes, so each app + func pair is treated as one equal-sized page, and RAM is a number of slots. The data cannot tell us real MB use, cold-start time or load cost, and the source page notes that the timestamps were modified from the production trace. Our result therefore shows how the policies behave on this workload only. It does not prove one policy is always best.

## Method and what we will build

We will build a Python simulator that reads the trace, orders the calls by start time (`end_timestamp` minus `duration`), turns each function into a page ID, and replays the calls through FIFO, LRU and Clock on the same workload at each RAM size. We will **not** build a real operating system, only a simulator.

**Output:** a table and line chart of fault rate against RAM size for the three policies, and a short write-up answering the research question.

**Tools (all free):** 7-Zip (to open the .rar), Python 3 with pandas and matplotlib, Excel (optional, for graphs), GitHub.

## Team plan

Roles are in the table above. One small task per member, the weekly plan and meeting minutes are in [docs/team-plan.md](docs/team-plan.md). Every member commits under their own GitHub account.

## Biggest risk and Plan B

