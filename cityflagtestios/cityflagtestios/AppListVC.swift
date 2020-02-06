//
//  AppListVc.swift
//  cityflagtestios
//
//  Created by Marco Antonio Martínez Gutiérrez on 1/30/20.
//  Copyright © 2020 Marco Antonio Martínez Gutiérrez. All rights reserved.
//

import UIKit

class AppListVC:UITableViewController{
    var presenter: AppViewToPresenterProtocol?
    
    let appS = AppDetail(name: "ID Please", images: [], summary: "Who will you let in?\n\nAs the new bouncer of the club, you decide who enters and who doesn\'t. Put your judgment skills to the test. Fun and easy to pick up and play.\n\n-Meet unique characters\n-Decide who makes the cut\n-No one under 21 allowed!\n-No hobos or drunks!", price: cityflagtestios.Price(amount: 0.0, currency: "USD"), contentType: cityflagtestios.ContentType(term: "Application", label: nil), rights: ("© 2019 NeverEnding Games"), title: "ID Please - Lion Studios", links: [], id: cityflagtestios.Id(id: "1486931468", bundleId: "com.NeverEndingGames.IdPlease", url: "https://apps.apple.com/us/app/id-please/id1486931468?uo=2"), artist: cityflagtestios.Artist(name: ("Lion Studios"), href: ("https://apps.apple.com/us/developer/lion-studios/id1362220666?uo=2")), category: cityflagtestios.Category(id: ("6014"), term: "Games", label: "Games", scheme: "https://apps.apple.com/us/genre/ios-games/id6014?uo=2"), releaseDate: cityflagtestios.ReleaseDate(label: "2019-11-29T23:56:45-07:00", date: "November 29, 2019"))
    var data:[AppDetail] = []
    
        
    override func viewDidLoad() {
        super.viewDidLoad()
        if presenter != nil {
            presenter?.getData()
        }
        data.append(appS)
        tableView.separatorStyle = .none
        
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return data.count
    }
       
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let cell = tableView.dequeueReusableCell(withIdentifier: "MyCell", for: indexPath) as! MyCell
        //let im = data[indexPath.row].images
        cell.title.text = "\(data[indexPath.row].title)"
        cell.content.text = "\(data[indexPath.row].summary)"
        print(data[indexPath.row].title)
        return cell
        
    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 120
    }
    
    
}

extension AppListVC: AppPresenterToViewProtocol{
    
    func presentData(_ data: [AppDetail]) {
        self.data = data
        tableView.reloadData()//???
        print("*****")
        print(data[0])
        DispatchQueue.main.async {
                   self.tableView.reloadData()
                   self.tableView.beginUpdates()
                   self.tableView.endUpdates()
               }
    }
    
}

class MyCell:UITableViewCell{
    @IBOutlet weak var myImage: UIImageView!
    @IBOutlet weak var title: UILabel!
    @IBOutlet weak var content: UILabel!
}
