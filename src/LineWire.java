

import java.util.LinkedList;
import java.util.Queue;


public class LineWire {
	private Path target;
	private Path origin;
	private Component comp[][]= new Component[27][36];
	private Component wire;
	private boolean isVisited=false;
	private boolean isQueued=false;
	private Queue<Path> queue=new LinkedList<Path>();
	private LinkedList<Path> path=new LinkedList<Path>();
	private Queue<Path> visited=new LinkedList<Path>();
	private Queue<Path> currvisited=new LinkedList<Path>();
	private Queue<Path> currqueue=new LinkedList<Path>();
	private boolean isJunction;
	public LineWire(Path origin,Path target,Component wire,boolean isJunction,Component comp[][])
	{
		this.comp=comp;
		this.isJunction=isJunction;
		this.wire=wire;
		this.origin=origin;
		this.target=target;
		Path originb=origin;
		BFS(originb);
	}
	public void BFS(Path axis)
	{
		visited.add(axis);
		getNeighbor(axis);
		
		    if(!queue.isEmpty())
		    {
		    	if(axis.getX()==this.target.getX() && axis.getY()==this.target.getY())
				{
					queue.clear();
					if(this.isJunction==true)
					{
						target.setJuction(true);
					}
					setPath(axis);
				}else
				{   
					
					BFS(queue.poll());
				}
				
		    }
		    
	}
	
	public void getNeighbor(Path a)
	{
		         
				for(int i=0;i<4; i++)
				{
					isVisited=false;
					isQueued=false;
					for(Path v:visited)
					{
						currvisited.add(v);
					}
					
					for(Path q:queue)
					{
						currqueue.add(q);
					}
					
					if(i==0 )
					{
						
						
						checkVisited(a.getX()-1,a.getY(),currvisited.poll() , currvisited);
						
						if(!currqueue.isEmpty())
						{
							checkQueue(a.getX()-1,a.getY(),currqueue.poll() , currqueue);
						}
						if(a.getX()-1>0)
						{
							if(isVisited==false && isQueued==false && comp[a.getY()][a.getX()-1]==null)
							{
								if(a.getX()>0 && a.getX()<37 && a.getY()>0 && a.getY()<27)
								{
									Path p = new Path(a.getX()-1,a.getY());
									p.setPrev(a);
									queue.add(p);
								}
							}
						}
					}else if(i==1)
					{
						
						
						checkVisited(a.getX()+1,a.getY(), currvisited.poll() , currvisited);
						
						if(!currqueue.isEmpty())
						{
							checkQueue(a.getX()+1,a.getY(),currqueue.poll() , currqueue);
						}
						if(a.getX()+1<36)
						{
							if(isVisited==false && isQueued==false  && comp[a.getY()][a.getX()+1]==null)
							{
								if(a.getX()>0 && a.getX()<37 && a.getY()>0 && a.getY()<27)
								{
								Path p = new Path(a.getX()+1,a.getY());
								p.setPrev(a);
								queue.add(p);
								}
							}
						}
					}else if(i==2)
					{
						
						
						checkVisited(a.getX(),a.getY()-1,currvisited.poll() , currvisited);
						
						if(!currqueue.isEmpty())
						{
							checkQueue(a.getX(),a.getY()-1,currqueue.poll() , currqueue);
						}
						if(a.getY()-1>0)
						{
							if(isVisited==false && isQueued==false  && comp[a.getY()-1][a.getX()]==null)
							{
								if(a.getX()>0 && a.getX()<37 && a.getY()>0 && a.getY()<27)
								{
								Path p = new Path(a.getX(),a.getY()-1);
								p.setPrev(a);
								queue.add(p);
								}
							}
						}
					}else if(i==3)
					{
						
						
						checkVisited(a.getX(),a.getY()+1,currvisited.poll() , currvisited);
						
						if(!currqueue.isEmpty())
						{
							checkQueue(a.getX(),a.getY()+1,currqueue.poll() , currqueue);
						}
						if(a.getY()+1<27)
						{
							if(isVisited==false && isQueued==false  && comp[a.getY()+1][a.getX()]==null)
							{
								if(a.getX()>0 && a.getX()<37 && a.getY()>0 && a.getY()<27)
								{
								Path p = new Path(a.getX(),a.getY()+1);
								p.setPrev(a);
								queue.add(p);
								}
							}
						}
					}
					
				}
			
		
	}
	public void checkVisited(int  x,int  y,Path index, Queue<Path> v)
	{
		
			if(index.getX()==x && index.getY()==y)
			{
				isVisited=true;
				v.clear();
			}
		
		if(!v.isEmpty())
		{
			checkVisited(x,y,v.poll(),v);
		}
	}
	public void checkQueue(int  x,int  y,Path index, Queue<Path> q)
	{
		
			if(index.getX()==x && index.getY()==y)
			{
				isQueued=true;
				q.clear();
			}
		
		if(!q.isEmpty())
		{
			checkQueue(x,y,q.poll(),q);
		}
	}
	
	int c=0;
	public void setPath(Path a)
	{
		
		a.setWire(this.wire);
		path.add(a);
		if(a.getX()==origin.getX() && a.getY()==origin.getY())
		{
			c=1;
		}
		if(c!=1)
		{
			setPath(a.getPrev());
		}
	}
	LinkedList<Path> getPath()
	{
		return this.path;
	}
}
