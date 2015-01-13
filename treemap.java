/**
* @Authors Tyler Smith Rutherford Lee 
* @login tylsmith rle
* @course cmps012b-wm.12
* @teacher Wesley Mackey
*/

public class treemap
{
  class tree
  {
    String key;
    String value;
    tree left;
    tree right; 
  }
  tree root = null;

  public String put(String key, String value)
  {
    tree tmp = new tree();
    tmp.key = key;
    tmp.value = value;
    if (root == null)
      root = tmp;
    else 
    {  
      tree curr = root;
      while(true)
      {
        int comp = curr.key.compareTo(tmp.key);
        if(comp < 0)
          // go right
          if(curr.right == null) 
            {
              curr.right = tmp;
              //new nod placed at curr.right
              break;
            }
          else curr= curr.right;
        else if(comp > 0)
        //go left
          if(curr.left == null)
          {
            curr.left = tmp;
            //new node placed at curr.left
            break;
          }        
          else curr = curr.left;
        else
        {
          curr.value = tmp.value;
          break;
        }
      } //end while loop
    }
   return tmp.value;
  } 

  public String get (String key)
  {
    tree curr = root;
    while(curr != null)
    {
      int comp = curr.key.compareTo(key);
      //System.err.printf("%d\n", comp);
      if(comp == 0) return curr.value;
      if(comp > 0)
        curr = curr.left;
      else
        curr = curr.right;
    }
    return null;
  }
  

  public void debug_tree()
  {
    printelements(root, 0);

  }
  public void printelements (tree node, int depth)
  {
     
     tree tmp = node;
     if (tmp == null) return;
     printelements (node.left, depth + 1);
     System.out.printf("depth= %d key= %s, value = %s, left child" +
      " = %s, right child = %s\n", depth, tmp.key, tmp.value,
               tmp.right, tmp.left);
     printelements (node.right, depth + 1);
  }
}
