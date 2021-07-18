import React, { useState, useEffect } from 'react'
import Blogs from './Blogs'
import axios from 'axios'
import Card from 'react-bootstrap/Card'
import ReactHtmlParser from 'react-html-parser';

export default function BlogsContainer() {

    const [api, setApi] = useState([]);


    useEffect(() => {
        console.log("In use effect");
        axios.get("http://localhost:8080/blogs")
            .then(json => {
                const result = json.data;
                setApi(json.data);
                console.log(api);
            }).catch(err => alert(err));
    }, [])


    return (
        <div className="container">
            <div className="wrapper">

                {api.map(i => <>
                    <Card style={{ width: '18rem', marginLeft: "18rem", textAlign: "centre" }}>
                        <Card.Body>
                            <Card.Title>Card Title</Card.Title>
                            <Card.Subtitle className="mb-2 text-muted">{i.description}</Card.Subtitle>
                            <Card.Text>{ReactHtmlParser(i.content)} </Card.Text>
                            <Card.Link href="#">Card Link</Card.Link>
                            <Card.Link href="#">Another Link</Card.Link>
                        </Card.Body>
                    </Card>
                    <p></p>
                    <p></p></>)}
            </div>
        </div>
    )
}
