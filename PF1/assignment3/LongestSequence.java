package assignment3;

// Find longest increasing subsequence from an array of integers
public class LongestSequence {
	
	/* store length of last longest occurring subsequence
	 * and compare every new sequence length
	 * */
	public int[] longestSequence(int[] input){
		if(input == null)
			throw new NullPointerException();
		
		if(input.length <0)
			throw new ArrayIndexOutOfBoundsException();
		
		if(input.length ==1 | input.length== 0) 
			return input;
		
		int[] tmp= new int[input.length];
		int k=0;		
		int max=0;
		int start_marker = 0, end_marker = 0;
		int i=0;
		
		for(i= start_marker; i < input.length-1; i++){
			if(input[i] >= input[i+1]){				
				/* break the sequence */
				end_marker = i;
				
				int len_seq = end_marker - start_marker+1;
				
				if(len_seq >= max){
					max = len_seq;
					
					/*Sub Sequence*/
					k=0;
					for(int x = start_marker; x< end_marker+1; x++){
						tmp[k] = input[x];				
						k++;
					}							
				}
			start_marker = i+1;
			}
		}
		
		/* Case: when i==length
		 * for sequence extending to end of string
		 */
		end_marker = i;
		int len_seq = end_marker - start_marker+1;
		
		if(len_seq >= max){
			max = len_seq;
			
			k=0;
			for(int x = start_marker; x< end_marker+1; x++){
				tmp[k] = input[x];				
				k++;
			}							
		}
		
		int[] result = new int[max];
		
		for(i=0; i<max; i++){
			result[i] = tmp[i];	
		}
		
		return result;
	}
}
