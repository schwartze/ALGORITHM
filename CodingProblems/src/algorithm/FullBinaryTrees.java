package algorithm;

import java.util.ArrayList;
import java.util.List;

public class FullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int N) {
    	if ( N == 0 && N % 2 == 0 )
    		return new ArrayList<>();

    	List<TreeNode> res = new ArrayList<>();
    	
    	if ( N == 1 ) {
    		res.add( new TreeNode( 0 ) );
    		return res;
    	}
    	
    	for ( int i = 1; i <= N; i += 2 ) {
    		List<TreeNode> left = allPossibleFBT( i );
    		List<TreeNode> right = allPossibleFBT( N - i - 1 );
    		
    		for ( TreeNode leftNode : left ) {
    			for ( TreeNode rightNode : right ) {
    				TreeNode root = new TreeNode( 0 );
    				root.left = leftNode;
    				root.right = rightNode;
    				res.add( root );
    			}
    		}
    	}
    	
    	return res;
    }
    
}
