class Matrix {

    int n, m;
    int[][] myMatrix;

    public Matrix(int n, int m)
    {
        this.n = n;
        this.m = m;
        this.myMatrix = new int[this.n][this.m];
    }

    public Matrix(int [][] sizeMatrix)
    {
        this.n = sizeMatrix.length;
        this.m = sizeMatrix[0].length;
        this.myMatrix = sizeMatrix;
    }

    public int getElem(int n, int m)
    {
        return this.myMatrix[n][m];
    }

    public void setElem(int n, int m, int val)
    {
        this.myMatrix[n][m] = val;
    }

    public int getColumn()
    {
        return this.myMatrix.length;
    }

    public int getLine()
    {
        return this.myMatrix[0].length;
    }


    public void printMatrix()
    {
        for(int i = 0; i < this.n; i++)
        {
            for(int j = 0; j < this.m; j++)
            {
                System.out.print(this.myMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static Matrix sum(Matrix m1, Matrix m2){
        Matrix newMatrix = new Matrix(m1.getColumn(), m2.getLine());
        for (int i = 0; i < newMatrix.getLine(); i++) {
            for(int j = 0; j < newMatrix.getColumn(); j++){
                newMatrix.setElem(i, j, m1.getElem(i, j) + m2.getElem(i, j));
            }
        }
        return newMatrix;
    }

    public static Matrix difference (Matrix m1, Matrix m2){
        Matrix newMatrix = new Matrix(m1.getColumn(), m2.getLine());
        for (int i = 0; i < newMatrix.getLine(); i++) {
            for(int j = 0; j < newMatrix.getColumn(); j++){
                newMatrix.setElem(i, j, m1.getElem(i, j) - m2.getElem(i, j));
            }
        }
        return newMatrix;
    }

    public static Matrix multiplicationByANumber (Matrix m1, int k) {
        Matrix newMatrix = new Matrix(m1.getColumn(), m1.getLine());
        for (int i = 0; i < newMatrix.getLine(); i++) {
            for(int j = 0; j < newMatrix.getColumn(); j++){
                newMatrix.setElem(i, j, m1.getElem(i, j) * k);
            }
        }
        return newMatrix;
    }

    public static Matrix multiplicationMatrix (Matrix m1, Matrix m2) {
         Matrix newMatrix;
         int n = m1.getColumn();
         int m = m2.getLine();
         int m2Column = m2.getColumn();
         int[][] newArr = new int[n][m];
         for(int i = 0; i < n; i++){
             for(int j = 0; j < m; j++){
                 for (int k = 0; k < m2Column; k++) {
                     newArr[i][j] += m1.getElem(i, k) * m2.getElem(k, j);
                 }
             }
         }
         newMatrix = new Matrix(newArr);
         return newMatrix;
    }

    public static Matrix transposition(Matrix m1) {
        Matrix newMatrix = new Matrix(m1.getColumn(), m1.getLine());
        for (int i = 0; i < newMatrix.getLine(); i++) {
            for(int j = 0; j < newMatrix.getColumn(); j++){
                newMatrix.setElem(i, j, m1.getElem(j, i));
            }
        }
        return newMatrix;
    }

    public static Matrix exponentiation (Matrix m1, int N) {
        Matrix newMatrix;
        int k = 1;
        int n = m1.getColumn();
        int m = m1.getLine();
        newMatrix = m1;
        while ( k < N ) {
            int[][] newArr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int l = 0; l < n; l++) {
                        newArr[i][j] += m1.getElem(i, l) * newMatrix.getElem(l, j);
                    }
                }
            }
            k++;
            newMatrix = new Matrix(newArr);
        }
        return newMatrix;
    }

    public static void main(String[] args) {

        int[][] A = {
                {4,-3,12},
                {10,2,0},
                {11,15,-7}
        };

        int[][] B = {
                {0,1,7},
                {8,-12,6,},
                {-14,9,2}
        };
        int k = 7;

        Matrix a = new Matrix(A);
        Matrix b = new Matrix(B);
        System.out.println("Матрица A:");
        a.printMatrix();
        System.out.println("Матрица B:");
        b.printMatrix();
        System.out.println("Сумма матрицы A и B:");
        Matrix sumM = Matrix.sum(a, b);
        sumM.printMatrix();
        System.out.println("Разность между матрицами A и B:");
        Matrix diffM = Matrix.difference(a, b);
        diffM.printMatrix();
        System.out.println("Умножение матрицы A на число:");
        Matrix multNumbM = Matrix.multiplicationByANumber(a, 7);
        multNumbM.printMatrix();
        System.out.println("Произведение матрицы A и B:");
        Matrix multM = Matrix.multiplicationMatrix(a, b);
        multM.printMatrix();
        System.out.println("Транспонированная матрица A:");
        Matrix transM = Matrix.transposition(a);
        transM.printMatrix();
        System.out.println("Возведение в степень матрицы A:");
        Matrix expM = Matrix.exponentiation(a, 4);
        expM.printMatrix();
    }
}