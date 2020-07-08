using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;


public class finish : MonoBehaviour {
    public Text text;
    public int p1, p2;
    public GameObject player1, player2;
	// Use this for initialization
	void Start () {
        Text text = GetComponent<Text>();
	}
	
	// Update is called once per frame
	void Update () {

		
	}
    public void OnCollisionEnter2D(Collision2D col)
    {
        if (col.gameObject.name == "Player1")
        {
                Debug.Log("finish");
                //text.text = "Финиш";
                p1++;
                //Application.LoadLevel("2_level");
        }
        if (col.gameObject.name == "Player2")
        {
            Debug.Log("finish");
            //text.text = "Финиш";
            p2++;
            //Application.LoadLevel("2_level");
        }
        if (p1 > 0 && p2 > 0)
        {
            text.text = "Финиш";
            Application.LoadLevel("2_level");
        }
    }
}
