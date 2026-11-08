7# What Stays in RAM? Page Replacement for a Low-Memory Server

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
|13| Miracle Mazulu|N02644912Y |Writing |

## Research question

On a low-memory server replaying the Azure Functions 2021 trace, which page replacement policy (FIFO, LRU or Clock) causes the fewest page faults at the same RAM size?

## Aim

To compare FIFO(First In ,First Out), LRU (Least Recently Used) and Clock page replacement on a real serverless workload, and find out which one keeps the most useful functions in a limited amount of RAM.

## Objectives

1. Build a Python simulator that replays a list of function calls through FIFO, LRU and Clock with a fixed number of RAM slots.
2. Run all three policies on the Azure Functions 2021 trace, treating each function as a page and each invocation as a page request, at RAM sizes of 1%, 5%, 10% and 25% of the distinct functions in the data.
3. Evaluate by measuring the page-fault rate (faults ÷ invocations) and the hit rate (hits ÷ invocations) at each RAM size, with FIFO as the baseline. A policy succeeds if it cuts the fault rate by at least 10% (relative to FIFO) at 3 or more of the 4 RAM sizes. The best policy is the one that succeeds and has the lowest average fault rate.


