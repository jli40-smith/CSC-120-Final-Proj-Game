interface Paginated
{
    public void open(String paginatedObj); 
    public void close(String paginatedObj);
    public void prevPage(); 
    public void nextPage();  
}