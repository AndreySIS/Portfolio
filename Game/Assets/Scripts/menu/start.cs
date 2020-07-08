using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class start : MonoBehaviour {

    public GameObject change_lvl, lvl1, lvl2, lvl3;
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}
    public void OnMouseDown()
    {
        change_lvl.SetActive(true);
        lvl1.SetActive(true);
        lvl2.SetActive(true);
        lvl3.SetActive(true);
        Debug.Log("21412");
    }
}
