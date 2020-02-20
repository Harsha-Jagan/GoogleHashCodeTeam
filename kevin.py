# General solution to put largest pizza and continue putting pizzas until they don't fit

import numpy as np
import sys


file_names = ['a_example.in', 'b_small.in', 'c_medium.in', 'd_quite_big.in', 'e_also_big.in']

#read input data, preprocess
for file_name in file_names:
    output_file_name = file_name.split('_')[0] + '.out'
    capacity, num_types, slices_per_pizza = -1, -1, []
    with open ('inputData/' + file_name, 'r') as file:
        info = file.read().splitlines()
        capacity = int(info[0].split(" ")[0])
        num_types = int(info[0].split(" ")[1])
        slices_per_pizza = info[1].split(" ")
    slices_per_pizza = np.array(slices_per_pizza).astype(int)
    # slices_per_pizza = np.sort(slices_per_pizza) # do i need sort?


    #start heuristic

    ITERATIONS = 10
    types_to_use = set()
    capacity_left = capacity


    for i in range(len(slices_per_pizza)):
        index = len(slices_per_pizza) - i - 1
        curr_pizza = slices_per_pizza[index]
        if capacity_left > curr_pizza:
            capacity_left -= curr_pizza
            types_to_use.add(index)


    #try to optimize by removing small pieces and filling them back in with alternate combinations

    # UNFINISHED
    # best_capacity_left = capacity_left
    # best_types_to_use = types_to_use.copy()
    #
    # for step in range(ITERATIONS):
    #     # print(types_to_use)
    #     removed = types_to_use.pop()
    #     print(removed)
    #     # print(types_to_use)
    #     # types_to_use.remove(removed)
    #     capacity_left += removed
    #     print(capacity_left)
    #     for i in range(len(slices_per_pizza)):
    #         index = len(slices_per_pizza) - i - 1
    #         curr_pizza = slices_per_pizza[index]
    #         if capacity_left > curr_pizza and curr_pizza != removed:
    #             capacity_left -= curr_pizza
    #             types_to_use.add(index)
    #     if capacity_left < best_capacity_left:
    #         best_capacity_left = capacity_left
    #         best_types_to_use = types_to_use.copy()


    with open ('output/' + output_file_name, 'w') as out:
        out.write(str(len(types_to_use)) + '\n')
        for type in types_to_use:
            out.write(str(type) + ' ')









