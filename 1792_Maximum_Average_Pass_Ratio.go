package main

type Heap[T any] struct {
	heap []T
	cmp  func(t1, t2 T) int
}

func maxAverageRatio(classes [][]int, extraStudents int) float64 {

	comparator := func(t1, t2 []int) int {
		ratio1 := computeRatioDiff(t1)
		ratio2 := computeRatioDiff(t2)
		if ratio1 > ratio2 {
			return -1
		} else if ratio1 == ratio2 {
			return 0
		}
		return 1
	}
	heap := NewHeap(comparator, classes...)
	for i := 0; i < extraStudents; i++ {
		class := heap.Dequeue()
		heap.Enqueue([]int{class[0] + 1, class[1] + 1})
	}
	total := float64(0)
	for _, v := range heap.GetAll() {
		total += computeRatio(v)
	}

	return total / float64(heap.length())
}

func computeRatio(class []int) float64 {
	return float64(class[0]) / float64(class[1])
}
func computeRatioDiff(class []int) float64 {
	return computeRatio([]int{class[0] + 1, class[1] + 1}) - computeRatio(class)
}

// constructor
func NewHeap[T any](comparator func(t1, t2 T) int, initialValues ...T) Heap[T] {
	var heap Heap[T]
	heap.cmp = comparator
	heap.heap = initialValues
	for i := len(heap.heap) / 2; i >= 0; i-- {
		heap.heapifyDown(i)
	}
	return heap
}

func (heap *Heap[T]) length() int {
	return len(heap.heap)
}

func (heap *Heap[T]) heapifyDown(idx int) {
	mostPriority := idx
	n := len(heap.heap)
	leftIdx := idx*2 + 1
	rightIdx := idx*2 + 2
	if leftIdx < n && heap.cmp(heap.heap[mostPriority], heap.heap[leftIdx]) > 0 {
		mostPriority = leftIdx
	}
	if rightIdx < n && heap.cmp(heap.heap[mostPriority], heap.heap[rightIdx]) > 0 {
		mostPriority = rightIdx
	}

	if mostPriority != idx {
		heap.swap(mostPriority, idx)
		heap.heapifyDown(mostPriority)
	}
}

func (heap *Heap[T]) GetAll() []T {
	return heap.heap
}
func (heap *Heap[T]) Dequeue() T {
	if len(heap.heap) <= 0 {
		panic("Attempted to dequeue empty heap")
	}
	ret := heap.heap[0]
	heap.swap(0, len(heap.heap)-1)
	heap.heap = heap.heap[:len(heap.heap)-1]
	heap.heapifyDown(0)
	return ret
}

func (heap *Heap[T]) Enqueue(val T) {
	heap.heap = append(heap.heap, val)
	heap.heapifyUp(len(heap.heap) - 1)
}

func (heap *Heap[T]) heapifyUp(idx int) {
	if idx <= 0 {
		return
	}
	var parent int
	if idx%2 == 0 {
		parent = (idx - 2) / 2
	} else {
		parent = (idx - 1) / 2
	}
	if heap.cmp(heap.heap[idx], heap.heap[parent]) < 0 {
		heap.swap(idx, parent)
		heap.heapifyUp(parent)
	}
}

func (heap *Heap[T]) swap(i, j int) {
	tmp := heap.heap[i]
	heap.heap[i] = heap.heap[j]
	heap.heap[j] = tmp
}
