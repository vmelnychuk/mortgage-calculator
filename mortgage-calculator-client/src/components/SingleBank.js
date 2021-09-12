import React from 'react';

const SingleBank = ({item}) => (
    <div className="row">
        <div className="col s12 m6">
            <div className="card blue-grey darken-1">
                <div className="card-content white-text">
                    <span className="card-title">{item.name}</span>
                    <ul>
                        <li>Interest rate {item.interestRate}</li>
                        <li>Maximum loan amount {item.maximumLoan}</li>
                        <li>Minimum down payment amount {item.minimumDownPayment}</li>
                        <li>Loan term {item.loanTerm}</li>
                    </ul>
                </div>
                <div className="card-action">
                    <a href="#">Edit</a>
                    <a href="#">Delete</a>
                </div>
            </div>
        </div>
    </div>
);

export default SingleBank;
