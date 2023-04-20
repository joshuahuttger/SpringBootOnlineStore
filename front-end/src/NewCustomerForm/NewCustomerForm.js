import React from 'react';


class NewCustomerForm extends React.Component {
	constructor(props) {
		super(props);
		this.state = { name: "" };
		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleChange(event) { this.setState({ name: event.target.value }); }
	handleSubmit(event) {
		alert('Name was submitted: ' + this.state.name);
		event.preventDefault();
		fetch('http://localhost:8080/customer', {
			method: 'POST',
			body: { name: "Chicken Tenders", id: "545454" }
		})
			.then(response => response.text()) // Read response as text
			.then(data => {
				console.log("data returned = "+data);
			})
	}

	render() {
		return (
			<form onSubmit={this.handleSubmit}>
				<label>
					Name:
					<input value={this.state.name} onChange={this.handleChange} />        </label>
				<input type="submit" value="Submit" />
			</form>
		);
	}
}

export default NewCustomerForm