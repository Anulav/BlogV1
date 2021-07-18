import React, { useState, useEffect } from 'react'
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import axios from 'axios'
import Form from 'react-bootstrap/Form'


export default function WriterComp() {
    const [content, setContent] = useState("");
    const [description, setDescritption] = useState("");


    const contentHandler = (event, editor) => {
        setContent(editor.getData());
        //    console.log(event.target.value);
        console.log("Content is now: " + content);


    }

    const descriptionHandler = (event) => {
        event.preventDefault();
        setDescritption(event.target.value);
        console.log(event.target.value);
        console.log("Description is now: " + content);
    }

    const submitHandler = (event) => {
        event.preventDefault();
        let blog = {
            content: content,
            description: description
        }
        console.log(blog);
        axios.post('http://localhost:8080/1/write', blog)
            .then(function (response) {
                alert(response);
            })
            .catch(function (error) {
                console.log(error);
            });

    }



    return (
        <div className="container">
            <div className="wrapper">
                <Form>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Description</Form.Label>
                        <Form.Control type="text" onChange={descriptionHandler} placeholder="Something that I need to know" />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                        <Form.Label>Example textarea</Form.Label>
                        <CKEditor
                            editor={ClassicEditor}
                            data="<p>Hello from CKEditor 5!</p>"
                            onReady={editor => {
                                // You can store the "editor" and use when it is needed.
                                console.log('Editor is ready to use!', editor);
                            }}
                            onChange={contentHandler}
                        /></Form.Group>
                    <input type="submit" onClick={submitHandler} value="Click Me!" />
                </Form>
            </div>
        </div>
    )
}
