interface Paginated
{
    public void open(String paginatedObj); 
    public void close();
    public void prevPage(); 
    public void nextPage();  
}