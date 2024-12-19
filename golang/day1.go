package main

import (
	"bufio"
	"fmt"
	"log"
	"math"
	"os"
	"sort"
	"strconv"
	"strings"
)

func Day1Solution(filepath string) {
	file, err := os.Open(filepath)

	if err != nil {
		log.Fatal("Error opening file", err)
	}

	defer file.Close()

	scanner := bufio.NewScanner(file)

	leftList := make([]int, 0)
	rightList := make([]int, 0)

	rightListOccurences := make(map[int]int)

	for scanner.Scan() {
		values := strings.Fields(scanner.Text())

		if len(values) != 2 {
			log.Fatal("Each row must have exactly 2 ints")
		}

		leftValue, err := strconv.Atoi(values[0])

		if err != nil {
			log.Fatal("Invalid value:", err)
		}

		rightValue, err := strconv.Atoi(values[1])

		if err != nil {
			log.Fatal("Invalid value:", err)
		}

		rightListOccurences[rightValue]++

		leftList = append(leftList, leftValue)
		rightList = append(rightList, rightValue)
	}

	if err := scanner.Err(); err != nil {
		log.Fatal("Error reading file", err)
	}

	sort.Ints(leftList)
	sort.Ints(rightList)

	totalDistance := 0.0
	similarityScore := 0

	for i := 0; i < len(leftList); i++ {
		dif := leftList[i] - rightList[i]
		totalDistance += math.Abs(float64(dif))

		value, ok := rightListOccurences[leftList[i]]

		if ok {
			similarityScore += value * leftList[i]
		}
	}

	fmt.Println("Part one:", totalDistance)
	fmt.Println("Part two:", similarityScore)
}
