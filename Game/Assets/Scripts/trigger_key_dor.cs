using UnityEngine;
using System.Collections;

public class trigger_key_dor : MonoBehaviour {
    public Animator animator;
    new private Rigidbody2D rigidbody ;
    public GameObject door, door1, key_open, key_close, gras, gras1,hole;
    private bool isClick = false;
    public Transform ClickCheck;
    private float ClickRadius = 0.4f;
    public LayerMask whatIsClick;
    public GameObject key;
    BoxCollider2D Boxcollider;

	// Use this for initialization
	void Start () {
       
	
	}
    private void Awake()
    {
        rigidbody = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();
        Boxcollider = GetComponent<BoxCollider2D>();
    }
	// Update is called once per frame
	void Update () {
	    
	}

    void OnCollisionEnter2D(Collision2D col)
    {
        if (col.gameObject.tag == "button" )
        {
            animator.SetBool("Click", true);
            
        }

    }
    void OnCollisionExit2D(Collision2D col)
    {
        if (col.gameObject.tag == "button")
        {
           animator.SetBool("Click", false);
        }
    }

   public void OnTriggerEnter2D(Collider2D col)
    {
        if (col.gameObject.tag == "button1")
        {
            //gras.active = true;
            gras.SetActive(true);
            gras1.SetActive(true);
            Destroy(hole);
        }
        if (col.gameObject.tag == "button2")
        {
            //gras.active = true;
            gras.SetActive(true);
            gras1.SetActive(true);
            Destroy(hole);
        }
        if (col.gameObject.tag == "batut")
        {
            key.transform.position = new Vector2(-6.05f, 12.6f);
        }
       
   }
   public void OnTriggerExit2D(Collider2D col)
   {
       if (col.gameObject.tag == "button2")
       {
           //gras.active = true;
           gras.SetActive(false);
           gras1.SetActive(false);
           Destroy(hole);
       }
   }


   //public void OnTriggerEnter2D(Collider2D col)
   //{
   //    if (col.gameObject.tag == "batut")
   //    {
   //        Boxcollider.isTrigger = false; 
   //    }
   //}

   public void FixedUpdate()
   {
       isClick = Physics2D.OverlapCircle(ClickCheck.position, ClickRadius, whatIsClick);
       //устанавливаем соответствующую переменную в аниматоре
       animator.SetBool("Click1", isClick);
       animator.SetBool("Click2", isClick);
   }
}
