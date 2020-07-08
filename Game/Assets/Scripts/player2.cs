using UnityEngine;
using System.Collections;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class player2 : MonoBehaviour
{
    //находится ли персонаж на земле или в прыжке?
    private bool isGrounded = false;
    //ссылка на компонент Transform объекта
    //для определения соприкосновения с землей
    public Transform groundCheck;
    //радиус определения соприкосновения с землей
    private float groundRadius = 0.8f;
    public Text text;
    //ссылка на слой, представляющий землю
    public LayerMask whatIsGround;
    public float speed = 5.0f;
    private float jump = 25.0f;
    new private Rigidbody2D rigidbody;
    private Animator animator;
    public GameObject door;
    private bool isFacingRight = true;
    public Animation animation;


    private void Awake()
    {
        rigidbody = GetComponent<Rigidbody2D>();
        animator = GetComponent<Animator>();
        animation = GetComponent<Animation>();
        
    }

    // Use this for initialization
    void Start()
    {
        animation.Play();
    }

    // Update is called once per frame
    void Update()
    {
        //если персонаж на земле и нажат пробел...
        if (isGrounded && Input.GetKeyDown(KeyCode.I))
        {
            //устанавливаем в аниматоре переменную в false
            animator.SetBool("Ground", false);
            //прикладываем силу вверх, чтобы персонаж подпрыгнул
            rigidbody.AddForce(new Vector2(0, 1000));
            
        }
    }

    public void FixedUpdate()
    {
        //определяем, на земле ли персонаж
        isGrounded = Physics2D.OverlapCircle(groundCheck.position, groundRadius, whatIsGround);
        //устанавливаем соответствующую переменную в аниматоре
        animator.SetBool("Ground", isGrounded);
        //устанавливаем в аниматоре значение скорости взлета/падения
        animator.SetFloat("vSpeed", rigidbody.velocity.y);
        //если персонаж в прыжке - выход из метода, чтобы не выполнялись действия, связанные с бегом
        if (!isGrounded)
            return;

        float move = Input.GetAxis("Horizontal1");


        animator.SetFloat("Speed", Mathf.Abs(move));


        rigidbody.velocity = new Vector2(move * speed, rigidbody.velocity.y);



        if (move > 0 && !isFacingRight)

            Flip();

        else if (move < 0 && isFacingRight)
            Flip();
    }

    private void Flip()
    {
        //меняем направление движения персонажа
        isFacingRight = !isFacingRight;
        //получаем размеры персонажа
        Vector3 theScale = transform.localScale;
        //зеркально отражаем персонажа по оси Х
        theScale.x *= -1;
        //задаем новый размер персонажа, равный старому, но зеркально отраженный
        transform.localScale = theScale;
    }
    //public void OnTriggerEnter2D(Collider2D col)
    //{
    //    if (col.gameObject.tag == "finish")
    //    {

    //        text.text = "Финиш";

    //    }

    //}

}
