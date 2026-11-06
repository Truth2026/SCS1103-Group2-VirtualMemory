# What Stays in RAM? Page Replacement for a Low-Memory Server

**SCS 1103 - Group 2**

https://github.com/n02646251d-png/SCS1103-Group2-VirtualMemory

Group members and roles

NAME                        Reg no       Plan 

Precious Memory Charamba  N02647137Y  Research

Tawana Macheka          N02643436W  Presenting

Carol Kachale           N0265210Y   Presenting

Sibusisiwe Ndowana     N02649564C     Research

Shoko Ezra            N02646251D      Build

Kuzakwawo Lesean       N02653121A      Build

Promise James         N02645998Y       Build

Rutendo Murambiwa     N02646586H     Research

Elina Muraidza         N02646369M     Research

Kuzhumbwa Tatenda     N02653651W      Writing

Miracle Mazulu        N02644912Y      Research

Allan Mashuwa          N02641360C      Writing

Taonashe Manyonga     N02646383W       Build

Research Question, Aim and Objectives
*Question:* Which page replacement policy keeps the most useful pages in RAM and causes fewest page faults on a low-memory server running serverless functions?

Aim: To compare page replacement policies and identify the best policy for low-memory servers using real Azure Functions traces.

Objectives
1. To implement FIFO, LRU and Clock page replacement simulators in Python using the Azure Functions 2021 trace.
2. To compare the policies on page faults and hit rate under different RAM sizes.
3. To evaluate by measuring page fault rate, hit rate and memory usage, comparing against FIFO as baseline. Success = lowest page fault rate with stable performance at 50% and 25% RAM size.

 OS Concept
Virtual memory and page replacement. When RAM is full, the OS must choose which page to evict to disk to make room. A bad choice causes a page fault and slow disk access.

 Why it matters, with a named public source:
Serverless platforms like Microsoft Azure Functions run thousands of short functions on shared low-memory servers. If the OS evicts the wrong pages, functions slow down and cost more. According to Microsoft Azure's public Azure Functions dataset (AzurePublicDataset, 2021), real invocations are bursty and unpredictable, so the OS cannot just keep the most recent pages. A better replacement policy directly improves speed and cost for cloud providers in Zimbabwe and worldwide.

Specific dataset and why we chose it
Dataset:Azure Functions 2021 trace - `github.com/Azure/AzurePublicDataset` - `AzureFunctionsInvocationTrace2021`
We chose it because it is public, from 2021 (meets the 2021-or-later rule), real-world not made-up, and it shows exactly how often functions are invoked, which we can turn into page requests for our simulator.

Method and what we will build:
We will build a Python simulator that reads the trace, converts function invocations into a page-reference string, then runs FIFO, LRU and Clock on the same workload. We will test each policy at 100%, 50% and 25% RAM size. We will NOT build a real OS, only a simulator. Tools: Python, GitHub, Excel for graphs.

 Team Plan
Week 1: All - clean dataset + agree on page mapping. Week 2: Developer codes simulators, Analyst prepares test workloads. Week 3: Tester runs all tests, Leader checks results. Week 4: All - write report, update README, submit. We meet twice a week on WhatsApp + 1 physical meet. Every member must commit on GitHub under their own account.

 Biggest risk and Plan B
Biggest Risk:The Azure trace is too large / too messy to parse and our simulator runs too slowly.
Plan B: Use a 1-day sample (e.g. 1 million rows) instead of the full 14 days, and if Python is still slow, use a smaller synthetic trace that follows the same pattern, and state this clearly in the report
