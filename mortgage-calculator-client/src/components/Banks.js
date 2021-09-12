import React, { Component } from 'react';
import SingleBank from './SingleBank';
import AddBank from './AddBank';

export default class Banks extends Component {
    constructor(props) {
        super(props);
        this.state = {
            banks: [],
        };
    }

    componentDidMount() {
        fetch('http://localhost:8080/api/banks')
            .then(response => response.json())
            .then(data => this.setState({banks: data}))
    }

    render() {
        return (
            <div>
                <div className="row">
                    <AddBank />
                </div>
                <div className="row">
                    { this.state.banks.map((item) => (
                        <SingleBank key={item.id} item={item} />
                    ))}
                </div>
            </div>
        )
    }
}
