﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class restart2lvl : MonoBehaviour {

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}
    void OnMouseDown()
    {
        Application.LoadLevel("2_level");

    }
}
