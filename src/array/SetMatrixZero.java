package com.pranav.striver_dsa_sheet.arraymedium;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] mat={{1,1,1,1},{1,0,0,1}, {1,1,0,1}, {1,1,1,1},{1,1,1,1}};
        SetMatrixZero obj=new SetMatrixZero();
        obj.setZeroMatrix_bruteForce(mat);
    }

    void setZeroMatrix_bruteForce(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    for(int x=0;x<mat.length;x++){
                        if(mat[x][j]!=0)mat[x][j]=-1;
                    }
                    for(int y=0;y<mat[0].length;y++){
                        if(mat[i][y]!=0)mat[i][y]=-1;
                    }
                }
            }

        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==-1)mat[i][j]=0;
            }
            System.out.println();
        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    void setZeroMatrix_better(int[][] mat){
        int[] row=new int[mat.length];
        int[] col=new int[mat[0].length];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }

        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(row[i]==1 || col[j]==1)mat[i][j]=0;
            }
        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }


    void setZeroMatrix_optimal(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
//                    row[i]=1;
//                    col[j]=1;
                }
            }

        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
//                if(row[i]==1 || col[j]==1)mat[i][j]=0;
            }
        }

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}


