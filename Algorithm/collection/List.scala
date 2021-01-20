/**
 * This file is part of Scalacaster project, https://github.com/vkostyukov/scalacaster
 * and written by Vladimir Kostyukov, http://vkostyukov.ru
 *
 * Linked List http://en.wikipedia.org/wiki/Linked_list
 *
 * Prepend - O(1)
 * Append - O(n)
 * Head - O(1)
 * Tail - O(1)
 * Lookup - O(n)
 */

abstract sealed class List[+A] {

  /**
   * The head of this list.
   */
  def head: A

  /**
   * The tail of this list.
   */
  def tail: List[A]

  /**
   * Checks whether this list is empty or not.
   */
  def isEmpty: Boolean

  /**
   * Appends the element 'x' to this list.
   * 
   * Time - O(n)
   * Space - O(n)
   */ 
  def append[B >: A](x: B): List[B] =
    if (isEmpty) List.make(x)
    else List.make(head, tail.append(x))

  /**
   * Prepends the element 'x' to this list. 
   *
   * Time - O(1)
   * Space - O(1)
   */
  def prepend[B >: A](x: B): List[B] = List.make(x, this)

  /**
   * Concatenates this list with given 'xs' list.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def concat[B >: A](xs: List[B]): List[B] = 
    if (isEmpty) xs
    else tail.concat(xs).prepend(head)

  /**
   * Removes the element 'x' from the list.
   * 
   * Time - O(n)
   * Space - O(n)
   */
  def remove[B >: A](x: B): List[B] = 
    if (isEmpty) fail("Can't find " + x + " in this list.")
    else if (x != head) List.make(head, tail.remove(x))
    else tail

  /**
   * Searches for the n-th element of this list.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def apply(n: Int): A =
    if (isEmpty) fail("Index out of bounds.")
    else if (n < 0) fail("Index (< 0) out of bounds.")
    else if (n == 0) head
    else tail(n - 1)

  /**
   * Checks whether this list contains element 'x' or not.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def contains[B >: A](x: B): Boolean = 
    if (isEmpty) false
    else if (x != head) tail.contains(x)
    else true

  /**
   * Exercise 2.1 @ PFDS.
   * 
   * Generates all the suffixes of this list.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def suffixes: List[List[A]] = 
    if (isEmpty) List.make(List.empty)
    else tail.suffixes.prepend(this)

  /**
   * Generates all the prefixes of this list.
   * 
   * Time - O(n^2)
   * Space - O(n)
   */
  def prefixes: List[List[A]] = {
    def helper(acc: List[List[A]], r: List[A]) : List[List[A]] = {
      if (r.isEmpty) acc
      else helper(List(acc.head ::: List(r.head)) ::: acc, r.tail)
    }
    if (isEmpty) this
    else helper(List(List(head)), tail)
  }

  /**
   * Applies the 'f' function to the each element of this list.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def foreach(f: (A) => Unit): Unit =
    if (!isEmpty) {
      f(head)
      tail.foreach(f)
    }

  /**
   * Combines all elements of this list into value.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def fold[B](n: B)(op: (B, A) => B): B = {
    def loop(l: List[A], a: B): B =
      if (l.isEmpty) a
      else loop(l.tail, op(a, l.head))

    loop(this, n)
  }

  /**
   * Creates new list by mapping this list to the 'f' function.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def map[B](f: (A) => B): List[B] = 
    if (isEmpty) List.empty
    else tail.map(f).prepend(f(head))

  /**
   * Calculates the sum of all elements of this list.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def sum[B >: A](implicit num: Numeric[B]): B = fold(num.zero)(num.plus)

  /**
   * Calculates the product of all elements of this list.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def product[B >: A](implicit num: Numeric[B]): B = fold(num.one)(num.times)

  /**
   * Searches for the minimal element of this list.
   * 
   * Time - O(n)
   * Space - O(n)
   */ 
  def min[B >: A](implicit ordering: Ordering[B]): B = 
    if (isEmpty) fail("An empty list.")
    else if (tail.isEmpty) head
    else ordering.min(head, tail.min(ordering))

  /**
   * Searches for the maximal element of this list.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def max[B >: A](implicit ordering: Ordering[B]): B = 
    if (isEmpty) fail("An empty list.")
    else if (tail.isEmpty) head
    else ordering.max(head, tail.max(ordering))

  /**
   * Slices this list.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def slice(from: Int, until: Int): List[A] = 
    if (isEmpty || until == 0) List.empty
    else if (from == 0) tail.slice(from, until - 1).prepend(head)
    else tail.slice(from - 1, until - 1)

  /**
   * Reverses this list.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def reverse: List[A] = { 
    def loop(s: List[A], d: List[A]): List[A] = 
      if (s.isEmpty) d
      else loop(s.tail, d.prepend(s.head))

    loop(this, List.empty)
  }

  /**
   * Shuffles this list.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def shuffle: List[A] = {
    val random = new scala.util.Random
    def insert(x: A, ll: List[A], n: Int): List[A] = 
      ll.slice(0, n).concat(ll.slice(n, ll.length).prepend(x))

    if (isEmpty) List.empty
    else insert(head, tail.shuffle, random.nextInt(tail.length + 1))
  }

  /**
   * Generates variations of this list with given length 'k'.
   * 
   * NOTES: To count number of variations the following formula can be used:
   * 
   * V_k,n = n!/(n - k)!
   *
   * Time - O(V_k,n)
   * Space - O(V_k,n)
   */
  def variations(k: Int): List[List[A]] = {
    def mixmany(x: A, ll: List[List[A]]): List[List[A]] =
      if (ll.isEmpty) List.empty
      else foldone(x, ll.head).concat(mixmany(x, ll.tail))

    def foldone(x: A, ll: List[A]): List[List[A]] = 
      (1 to ll.length).foldLeft(List.make(ll.prepend(x)))((a, i) => a.prepend(mixone(i, x, ll)))

    def mixone(i: Int, x: A, ll: List[A]): List[A] = 
      ll.slice(0, i).concat(ll.slice(i, ll.length).prepend(x))

    if (isEmpty || k > length) List.empty
    else if (k == 1) map(List.make(_))
    else mixmany(head, tail.variations(k - 1)).concat(tail.variations(k))
  }

  /**
   * Generates all permutations of this list.
   *
   * NOTES: To count number of permutations the following formula can be used:
   *
   * P_n = V_n,n = n!
   *
   * Time - O(P_n)
   * Space - O(P_n)
   */
  def permutations: List[List[A]] = 
    (2 to length).foldLeft(variations(1))((a, i) => variations(i).concat(a))

  /**
   * Searches for the longest increasing sub list of this list.
   *
   * http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
   *
   * Time - O(n^2)
   * Space - O(n)
   */
  def longestIncreasingSubsequence[B >: A](implicit ordering: Ordering[B]): List[B] = {
    // We can use the following instead:
    // zipWithIndex.map(t => (t._2, List(t._1))).toMap
    // http://stackoverflow.com/questions/17828431/convert-scalas-list-into-map-with-indicies-as-keys
    def init(i: Int, l: List[A], m: Map[Int, List[A]]): Map[Int, List[A]] = 
     if (l.isEmpty) m
     else init(i + 1, l.tail, m + (i -> List(l.head)))

    def loop(i: Int, l: List[A], m: Map[Int, List[A]]): List[A] =
      if (l.isEmpty) m.maxBy(_._2.length)._2.reverse
      else {
        val f = m.filter(p => p._1 < i && ordering.lt(p._2.head, l.head))
        if (f.isEmpty) loop(i + 1, l.tail, m)
        else {
          val (_, ll) = f.maxBy(_._2.length)
          loop(i + 1, l.tail, m + (i -> ll.prepend(l.head)))
        }
      }

    if (isEmpty) List.empty
    else loop(1, tail, init(0, this, Map[Int, List[A]]()))
  }

  /**
   * Searches for the longest common sub-sequence of this and 'l' lists.
   *
   * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
   *
   * TODO: The DP approach can be used here to reduce the complexity to O(mn)
   *
   * Time - O(2^n)
   * Space - O(n)
   */
  def longestCommonSubsequence[B >: A](l: List[B]): List[B] = {
    def loop(a: List[A], b: List[B], c: List[B]): List[B] = 
      if (a.isEmpty || b.isEmpty) c
      else if (a.head == b.head) loop(a.tail, b.tail, c.prepend(a.head))
      else {
        val la = loop(a.tail, b, c)
        val lb = loop(a, b.tail, c)
        if (la.length > lb.length) la else lb
      }

    loop(reverse, l.reverse, List.empty)
  }

  /**
   * Returns the number of inversions that required to make this list sorted.
   *
   * http://www.geeksforgeeks.org/counting-inversions/
   *
   * Time - O(n log n)
   * Space - O(n)
   */
  def inversions[B >: A](implicit ordering: Ordering[B]) : Int = {
    def enhancedmergesort(l: List[B]) : (List[B], Int) = {
      def loop(ll: List[B], pivotIdx: Int, inv: Int) : (List[B], Int) = {
        unpackmerge(
          enhancedmergesort(ll.slice(0, pivotIdx)),
          enhancedmergesort(ll.slice(pivotIdx, ll.size)),
          inv
        )
      }
      def unpackmerge(a: (List[B], Int), b: (List[B], Int), inv: Int) : (List[B], Int) = {
        merge(List.empty[B], a._1, b._1, a._2 + b._2 + inv)
      }
      def merge(acc: List[B], a: List[B], b: List[B], inv: Int) : (List[B], Int) = {
        if (a.isEmpty) (acc ::: b, inv)
        else if (b.isEmpty) (acc ::: a, inv)
        else if (ordering.lte(a.head, b.head)) merge(acc ::: List(a.head), a.tail, b, inv)
        else (ordering.gt(a.head, b.head)) merge(acc ::: List(b.head), a, b.tail, inv + a.size)
      }
      if (l.size < 2) (l, 0)
      else loop(l, (new scala.util.Random).nextInt(l.size), 0)
    }
    enhancedmergesort(this)._2
  }

  /**
   * Count the largest sum of contiguous sub list.
   *
   * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
   * 
   * NOTES: It uses the DP-approach based on Kadane’s algorithm.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def largestSumOfContiguousSubList[B >: A](implicit num: Numeric[B]): B = {
    def loop(sm: B, gm: B, l: List[B]): B = 
      if (l.isEmpty) gm
      else {
        val nsm = num.max(l.head, num.plus(sm, l.head))
        loop(nsm, num.max(gm, nsm), l.tail)
      }

    if (isEmpty) fail("An empty list.")
    else loop(head, head, tail)
  }

  /**
   * Generates all the sub-sequences of this list.
   *
   * Time - O(2^n)
   * Space - O(n)
   */
  def subsequences: List[List[A]] =
    if (isEmpty) List.empty
    else { 
      val ss = tail.subsequences 
      ss.map(_.prepend(head)).prepend(List.make(head)).concat(ss)
    }

  /**
   * Builds the increasing sub-sequence with maximum sum.
   *
   * http://www.geeksforgeeks.org/dynamic-programming-set-14-maximum-sum-increasing-subsequence/
   *
   * Time - O(n^2)
   * Space - O(n^2)
   */
  def maximumSumIncreasingSubsequence: List[A] = {
    def sum(l: List[A]): A = {
      l.foldLeft(0)((a, b) => a + b)
    }
    def update(l: List[List[A]], i: Int, o: List[A]): List[List[A]] = {
      def updateHelper(h: List[List[A]], t: List[List[A]], j: Int): List[List[A]] = {
        if (t.isEmpty) reverse(h)
        else if (i == j) updateHelper(o :: h, t.tail, j + 1)
        else updateHelper(t.head :: h, t.tail, j + 1)
      }
      def reverse(ll: List[List[A]]): List[List[A]] = {
        def reverseHelper(h: List[List[A]], t: List[List[A]]): List[List[A]] = {
          if (t.isEmpty) h
          else reverseHelper(t.head :: h, t.tail)
        }
        reverseHelper(List.empty[List[A]], ll)
      }
      updateHelper(Nil, l, 0)
    }
    def loop(msis: List[List[A]], i: Int, j: Int): List[List[A]] = {
      if (i >= msis.length) msis
      else if (j >= i) loop(msis, i + 1, 0)
      else if (apply(i) > apply(j) && sum(msis(i)) < sum(msis(j)) + apply(i) && i - j == msis(i).length) {
        loop(update(msis, i, msis(j) ++ List(apply(i))), i, j + 1)
      } else loop(msis, i, j + 1)
    }
    def maxBySum(msis: List[List[A]]): List[A] = {
      def maxBySumHelper(b: List[A], bSum: Int, t: List[List[A]]): List[A] = {
        if (t.isEmpty) b
        else if (sum(t.head) > bSum) maxBySumHelper(t.head, sum(t.head), t.tail)
        else maxBySumHelper(b, bSum, t.tail)
      }
      maxBySumHelper(msis.head, sum(msis.head), msis.tail)
    }
    maxBySum(loop(this.map(x => List[A](x)), 0, 0))
  }

  /**
   * Returns an intersect nodes of two lists.
   *
   * http://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
   *
   * Time - O(n)
   * Space - O(n)
   */
  def intersect[B >: A](l: List[B]) : List[B] = {
    def jointail(a: List[B], b: List[B]) : List[B] = {
      if (a.isEmpty || b.isEmpty) List.empty[B]
      else if (a.head == b.head) a
      else jointail(a.tail, b.tail)
    }
    def ntail(n: B, a: List[B]) : List[B] = {
      if (n < 0 || a.isEmpty) List.empty[B]
      else if (n == 0) a
      else ntail(n - 1, a.tail)
    }
    if (isEmpty || l.isEmpty) List.empty[B]
    else if (size < l.size) l.intersect(this)
    else jointail(ntail(size - l.size, this), l)
  }

  /**
   * Returns the longest palindromic sub-sequence of this list.
   *
   * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
   *
   * Time - O(n^2)
   * Space - O(n^2)
   */
  def longestPalindromicSubsequence: List[A] = {
    def max(a: Int, b: Int) = if (a > b) a else b
    def setM(m: Map[(Int, Int), Int], cl: Int, i: Int, j: Int): Map[(Int, Int), Int] = {
      if (apply(i) == apply(j) && cl == 2) m + ((i, j) -> 2)
      else if (apply(i) == apply(j) && m((i + 1, j - 1)) == j - i - 1) m + ((i, j) -> (m((i + 1, j - 1)) + 2))
      else m + ((i, j) -> max(m((i + 1, j)), m((i, j - 1))))
    }
    def loop(m: Map[(Int, Int), Int], cl: Int, i: Int): Int = {
      if (cl > length) m((0, length - 1))
      else if (i >= length - cl + 1) loop(m, cl + 1, 0)
      else loop(setM(m, cl, i, i + cl - 1), cl, i + 1)
    }
    def initialize(m: Map[(Int, Int), Int], i: Int, j: Int): Map[(Int, Int), Int] = {
      if (i >= length) m
      else if (j >= length) initialize(m, i + 1, 0)
      else if (i == j) initialize(m + ((i, j) -> 1), i, j + 1)
      else initialize(m + ((i, j) -> 0), i, j + 1)
    }
    loop(initialize(Map.empty[(Int, Int), Int], 0, 0), 2, 0)
  }

  /**
   * Calculates the length of this list.
   *
   * Time - O(n)
   * Space - O(n)
   */
  def length: Int = 
    if (isEmpty) 0 
    else 1 + tail.length

  /**
   * Converts this list into the string representation.
   * 
   * Time - O(n)
   * Space - O(n)
   */
  override def toString: String = {
    def loop(h: A, t: List[A], s: String): String = 
      if (!t.isEmpty) loop(t.head, t.tail, s + h + ", ")
      else s + h

    if (isEmpty) "List[]"
    else "List[" + loop(head, tail, "") + "]"
  }

  /**
   * Fails with given message.
   */
  def fail(m: String) = throw new NoSuchElementException(m)
}

case object Nil extends List[Nothing] {
  def head: Nothing = fail("An empty list.")
  def tail: List[Nothing] = fail("An empty list.")

  def isEmpty: Boolean = true
}

case class Cons[A](head: A, tail: List[A]) extends List[A] {
  def isEmpty: Boolean = false
}

object List {

  /**
   * An empty list.
   */
  def empty[A]: List[A] = Nil

  /**
   * A smart constructor for list's cons.
   */
  def make[A](x: A, t: List[A] = Nil): List[A] = Cons(x, t)

  /**
   * Creates a new list from given 'xs' sequence.
   *
   * Time - O(n)
   * Space - O(1)
   */
  def apply[A](xs: A*): List[A] = {
    var r: List[A] = List.empty
    for (x <- xs.reverse) r = r.prepend(x)
    r
  }
}
