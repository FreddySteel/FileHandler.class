class Main {
    public static void main(String[] args) {
        // test the database works
        System.out.println("Database");
        Database db = new Database("test.txt", 10);
        db.appendRecord("1.ABCDEFGH");
        db.appendRecord("2.ABCDEFGH");
        db.appendRecord("3.ABCDEFGH");
        db.appendRecord("4.ABCDEFGH");
        db.appendRecord("5.IJKLM");
        System.out.println(db.getRecord(2));	 // should be "3.ABCDEFGH"
        System.out.println(db.findRecord("EBCDEFGHIJ","test.txt")); // false
        System.out.println(db.findRecord("2.ABCDEFGH","test.txt")); // true
        System.out.println(db.getRecordCount(db)+" rows ");
        //System.out.println("count = " + db.getRecordCount()); // 4
    }
}
