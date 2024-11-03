class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        # make a set
        # if list is one or less set to false
        # iterate through list and if list element is in set return false else add to set
        if len(nums)<=1:
            return False
        set = set()
        for num in range(nums):
            if num in set:
                return True
            else:
                set.add(num)
        return False