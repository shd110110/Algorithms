package leetCodeHard;

/**
 * @author Poirot
 * 2015年9月14日
 */
public class MedianofTwoSortedArrays {
    public int _findOfCH(int A[], int m, int B[], int n, int k) {
    	
		if (k == 0) {
			return A[0] <= B[0] ? A[0] : B[0];
		}
		int l = 0, h = m - 1;
		int mid = l + (h - l) / 2;
		while (l <= h) {
			mid = l + (h - l) / 2; // A[mid], mid elements at the left side
										// in A.
			// k-mid elements at the left side in B.
			if (k - mid < 0) {
				h = mid - 1;
			} else if (k - mid == 0) {
				if (B[0] >= A[mid]) {
					
					return A[mid];
				} else {
					h = mid - 1;
				}
			} else if (k - mid > n) {
				l = mid + 1;
			} else if (k - mid == n) {
				if (A[mid] >= B[n - 1]) {
					return A[mid];
				} else {
					l = mid + 1;
				}
			} else {
				if (A[mid] >= B[k - mid - 1] && A[mid] <= B[k - mid]) {
					return A[mid];
				} else if (A[mid] < B[k - mid - 1]) {
					l = mid + 1;
				} else {
					h = mid - 1;
				}
			}
		}
		
		return Integer.MIN_VALUE;
	}

	public int findOfCH(int A[], int m, int B[], int n, int k)  {
		
		int v = _findOfCH(A, m, B, n, k);  // Try to search in A.
		return   (v > Integer.MIN_VALUE) ? v: _findOfCH(B, n, A, m, k);  // Search in B.
	}

	public double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		if(n == 0)
			return  m%2==1 ? A[m/2] : (A[m/2-1]+A[m/2])/2.0;
		if(m == 0)
			return  n%2==1 ? B[n/2] : (B[n/2]+B[n/2-1])/2.0;
		if( (m+n)%2==1)
		{
			return findOfCH(A, m, B, n, (m+n)/2);
		}else {
			return (findOfCH(A, m, B, n, (m+n)/2) + findOfCH(A, m, B, n, (m+n)/2-1))/2.0;
		} 
	}
	
	
	// Second Round 6ms O(log(min(m, n)))
	
//	public int getUpMedian(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2) {
//		int mid1 = 0;
//		int mid2 = 0;
//		int offset = 0;
//		while (start1 < end1) {
//			mid1 = (start1 + end1) / 2;
//			mid2 = (start2 + end2) / 2;
//			offset = ((end1 - start1 + 1) & 1) ^ 1; // 长度是偶数则为1， 奇数则为0
//			if (arr1[mid1] > arr2[mid2]) {
//				end1 = mid1; 
//				start2 = mid2 + offset;
//			} else if (arr1[mid1] < arr2[mid2]) {
//				end2 = mid2;
//				start1 = mid1 + offset;
//			} else {
//				return arr1[mid1];
//			}
//		}
//		return Math.min(arr1[start1], arr2[start2]);
//	}
//	
//	public int findKthSmallNum(int[] arr1, int[] arr2, int kth) { 
//		int[] longs = arr1.length >= arr2.length ? arr1 : arr2;
//		int[] shorts = arr1.length < arr2.length ? arr1 : arr2; 
//		if (shorts.length == 0) {
//			return longs[kth - 1];
//		}
//		int longlength = longs.length;
//		int shortLength = shorts.length; 
//		if (kth <= shortLength) {
//			return getUpMedian(shorts, 0, kth - 1, longs, 0, kth - 1);
//		} 
//		if (kth > longlength) {
//			if (shorts[kth - longlength - 1] >= longs[longlength - 1]) {
//				return shorts[kth - longlength - 1];
//			}
//			if (longs[kth - shortLength - 1] >= shorts[shortLength - 1]) {
//				return longs[kth - shortLength - 1];
//			}
//			return getUpMedian(shorts, kth - longlength, shortLength - 1, longs, kth - shortLength, longlength - 1);
//		}
//		if (longs[kth - shortLength - 1] >= shorts[shortLength - 1]) {
//			return longs[kth - shortLength - 1];
//		}
//		return getUpMedian(shorts, 0, shortLength - 1, longs, kth - shortLength, kth - 1);
//	}
//    
//	public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
//		if ( (nums1.length+ nums2.length) % 2 == 0) {
//			int k = (nums1.length + nums2.length) / 2 ;
//			return ( (double)((findKthSmallNum(nums1, nums2, k ) + findKthSmallNum(nums1, nums2, k + 1)))) / 2;
//		} else {
//			return (double) findKthSmallNum(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
//		} 	 
//    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianofTwoSortedArrays t = new MedianofTwoSortedArrays();
		int[] nums1 = {1};
		int[] nums2 = {2};
		System.out.println(t.findMedianSortedArrays(nums1, nums2));
	}

}
