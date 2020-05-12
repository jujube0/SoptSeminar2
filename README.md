# SoptSeminar2
> bottomNavigation, Viewpager,  recycerview, glide
> 

	// build.gradle
	// bottomnavigation 
	implementation "com.google.android.material:material:1.2.0-alpha05"
	// recyclerview
	implementation 'androidx.recyclerview:recyclerview:1.1.0'
	//glide
	implementation "com.github.bumptech.glide:glide:4.10.0"
	
## ViewPager와 BottomNavigation
viewPager는 swipe를 가능하게 하는. bottom navigation은 하단의 탭으로 탭을 통해 화면전환시킨다.
>Fragment
>액티비티 내의 화면 ui 일부

프래그먼트를 viewPager에 등록하고, bottom navigation에 연결 by adapter
		
	//adapter
	class MainPagerAdapter(fm: FragmentManager):  
	FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){  
	    override fun getItem(position: Int): Fragment {
	        return when(position){  
	            0 -> Home()  
	            1 -> Library()  
	            else -> MyPage()  
	        }  
	    }  
  
	    override fun getCount(): Int {  
        return 3  
		  }  
		}
> **int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT:**
> indicates that only the current fragment will be in the Lifecycle.State.RESUMED state. All the other Fragments are capped at Lifecycle.State.STARTED

	//main
	main_viewPager.adapter = MainPagerAdapter(supportFragmentManager)
	//in fragment: childFragmentManager()
	main_viewPager.offscreenPageLimit=2

	
> **setOffScreenPageLimit** :
 default 값은 1, -> 좌우 1개 화면 미리 생성하고 그 이외의 화면은 제거
 2로 설정하면, 좌우 두 개 화면을 미리 생성

## Recyclerview
1. layout에 반복될 view 만들어주기
>data class ()
>[toString(), hashCode(),equals(),copy() method를 자동으로 만들어준다.](https://codechacha.com/ko/data-classes-in-kotlin/)
2. viewHolder 만들기
: 각 view를 보관한다. findViewById를 매번 해주는 것을 방지

		class InstaViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){  
		    val img : ImageView = itemView.findViewById<ImageView>(R.id.image_main)  
		    val tv_title = itemView.findViewById<TextView>(R.id.tv_title)  
		    val tv_content = itemView.findViewById<TextView>(R.id.tv_content)  
  
		    fun bind(instaData : InstaData){  
	        tv_title.text = instaData.title  
			tv_content.text=instaData.content  
			Glide.with(itemView).load(instaData.img_url).into(img)  
		    }  
		}
		
3. adapter
: 

		class InstaAdapter(private val context: Context): RecyclerView.Adapter<InstaViewHolder>() {  
			
			var datas: MutableList<InstaData> = mutableListOf()
			
			// xml file을 inflate한 후 viewHolder를 만든다.
		    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstaViewHolder {  
			    val view = LayoutInflater.from(context).inflate(R.layout.item_insta, parent,false)  
				return InstaViewHolder(view)
		    }  
  
		    override fun getItemCount(): Int {  
				 return datas.size
		    }  
			  // viewholder의 항목을 구성하기 위해 호출된다.
		    override fun onBindViewHolder(holder: InstaViewHolder, position: Int) {  
		    }  
		}
	
	> [**Mutable list: list를 상속받는다. arraylist는 이 mutable list를 상속 받는다.**](https://salix97.tistory.com/235)
	When you write  val a = mutableListOf(), you're saying "I want a mutable list, and I don't particularly care about the implementation". When you write, instead,  val a = ArrayList(), you're saying "I specifically want an ArrayList".
4. layoutmanager : recyclerview xml에 추가가능
	
		app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
		
>**ItemDecoration**
>onDraw: 항목 배치 전 호출 - 항목 밑에 그리기
>onDrawOver: 모든 항목이 배치된 후에 호출 - 항목 위에 그리기
>getItemOffsets: 각 항목을 배치할 때 호출

>**clipToPadding**
>recyclerview위아래에 padding을 주면 그만큼 scroll영역이 작아지는데 이를 방지하는 것.
>clipToPadding = "false"

## GridLayoutManager
Gridlayoutmanager를 이용했다.
spancount(한 줄에 몇 개나 넣을 지)를 설정해야함
>**itemview사이즈 동적으로 설정하기**
	>		  
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WebtViewHolder {  
	    val view = LayoutInflater.from(context).inflate(R.layout.item_webtoon, parent,false)  
	    val width: Int = parent.getMeasuredWidth() / 3  
		 view.layoutParams.width = width  
	    view.requestLayout()  
	    return WebtViewHolder(view)  
	}

*staggeredGridlayoutmanager:불규칙

## Tabs with viewPager
		
	
	private class PagerAdapter(fm: FragmentManager):  
	    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){  
	    override fun getItem(position: Int): Fragment {  
	        return when(position){  
	            0 -> Webt_Mon()  
	            1 -> Webt_Tue()  
	            else -> Webt_wednes()  
	        }  
	    }  
	  
    override fun getCount(): Int {  
        return 3  
	  }  
	  // tab의 string 구성
    override fun getPageTitle(position: Int): CharSequence? {  
        when(position){  
            0->return "monday"  
	  1->return "tuesday"  
	  else-> return "wednesday"  
	  }  
	    }  
	}


