using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class restart : MonoBehaviour {
    public GameObject lvlv1, lvlv2, lvlv3, lvlv4;
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}
    void  OnMouseDown()
    {
        Application.LoadLevel("1_level");

    }
    
}
