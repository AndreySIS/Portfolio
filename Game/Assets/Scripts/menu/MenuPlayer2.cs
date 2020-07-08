using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MenuPlayer2 : MonoBehaviour {

    private Animator animator;

    private void Awake()
    {
        animator = GetComponent<Animator>();
    }
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}

    public void FixedUpdate()
    {
        animator.Play("Player2Run");
    }
}
