int removeElement(int* nums, int numsSize, int val) {
   int count=0,temp;
   for (int index = 0; index < numsSize; index++){
        if (nums[index]!=val){
            temp = nums[index];
            nums[index]=nums[count];
            nums[count]=temp;
            count++;
        }
   }
   return count;
}