class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor=image[sr][sc];
        if(oldcolor==color) return image;
        fill(image, sr, sc, oldcolor, color);
        return image;
    }

    void fill(int [][] image, int r, int c, int oldcolor, int newcolor){
        if(r<0||c<0|| r>=image.length|| c>=image[0].length) return;

        if(image[r][c]!=oldcolor) return;
        image[r][c]=newcolor;
        fill(image, r+1, c, oldcolor, newcolor);
        fill(image, r-1, c, oldcolor, newcolor);
        fill(image, r, c+1,  oldcolor, newcolor);
        fill(image, r, c-1, oldcolor, newcolor);

    }
}