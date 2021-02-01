package seed;

import model.Products;

import java.util.ArrayList;

public class Tree {
    public Node root;



    public Node germinateSeed(ArrayList<Products> productslist, Node root, int i) {

            // Base case for recursion
            if (i < productslist.size()) {
                Node temp = new Node(productslist.get(i));
                root = temp;

                // insert left child
               root.pleft = germinateSeed(productslist, root.pleft,
                        2 * i + 1);
                // insert right child
                root.pright = germinateSeed(productslist, root.pright,
                        2 * i + 2);
            }
            return root;
        }
        public void FindTree(int id,Node root) {
        int row =  (int)Math.round((Math.sqrt(id)));
            System.out.println(row + "row");
        if(root == null) {
            System.err.println("not found");
            return;
        }
        if(root.product.getId() == id) {
            System.out.println(root.product.getName());
            return;
        }else{
            double ml = Math.round((double)id / root.pleft.product.getId());
            double nl =root.pleft.product.getId() * ml;
            if(nl +1 == id || nl +2 == id ) {
             root= root.pleft;
             System.out.println("R");
             FindTree(id,root);
         }
            double mr = Math.round((double)id / root.pright.product.getId());
            double nr = root.pright.product.getId() * mr;
            if(nr +1 == id || nr +2 == id )  {
                root= root.pright;
                System.out.println("L");
                FindTree(id,root);
            }
        }
        }
    }


